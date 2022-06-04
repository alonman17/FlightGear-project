package com.flightgearserver.demo.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    Logger logger= LoggerFactory.getLogger("agentManager");
    //Helper property to make this observable
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
        if(clients.containsKey(id)){
            var client=clients.get(id);
            clients.remove(id);
            client.close();
            logger.info("Aircraft " + id + " just went offline");
            aircraftIds[id]=0;
            support.firePropertyChange(String.valueOf(id),1,0);
        }
    }

    public String[] getAllLiveFlightsValues() {
        String[] values=new String[clients.size()];
        int i=0;
        for (var client:clients.values()) {
            values[i]=client.getFlightLiveValues().toString();
            i++;
        }
        return values;
    }

    public int getCountOfAgents() {
        return clients.size();
    }
}
