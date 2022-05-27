package com.flightgearserver.demo.agent;

import com.flightgearserver.demo.Http.Aircraft.AircraftService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Used to manage all the agents.
 */

public class AgentManager {
    private static AgentManager manager;
    private Map<Integer, AgentHandler> clients;
    //TODO FIX THE SERVICE
//    @Autowired
//    private AircraftService service;
    private int[] aircraftIds;
    int size=10;

    Logger logger= LoggerFactory.getLogger(AgentManager.class);
    private PropertyChangeSupport support;

    private AgentManager() {
        clients=new HashMap<>();
        aircraftIds=new int[size];
        support=new PropertyChangeSupport(this);
    }

    public static AgentManager getInstance(){
        if(manager==null){
            manager=new AgentManager();
        }
        return manager;
    }

    public int addAgent(AgentHandler agent){
        int id=findFreeAircraft();
        logger.info("Aircraft " + id + " just went online");
        clients.put(id,agent);
        return id;
    }

    private int findFreeAircraft(){
        Random random=new Random();
        for (int i = 0; i < aircraftIds.length; i++) {
                int x=random.nextInt(10);
                if(aircraftIds[x]==1) {
                    continue;
                }
                support.firePropertyChange(String.valueOf(x),0,1);
                aircraftIds[x]=1;
            System.out.println(x);
                return x;
            }
        return -1;
    }
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
    public AgentHandler getAgent(int id){
        return clients.get(id);
    }

    public void removeAgent(int id) {
        clients.get(id).close();
        clients.remove(id);
        logger.info("Aircraft " + id + " disconnected");
        aircraftIds[id]=0;
        support.firePropertyChange(String.valueOf(id),1,0);

    }
}
