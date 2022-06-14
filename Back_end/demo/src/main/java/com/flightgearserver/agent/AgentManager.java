package com.flightgearserver.agent;

import com.flightgearserver.ApplicationContextUtils;
import com.flightgearserver.Http.Aircraft.AircraftService;
import com.flightgearserver.liveCache.FlightLiveValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Used to manage all the agents.
 */
@Configurable
public class AgentManager {
    private static AgentManager manager;
    private Map<Integer, AgentHandler> clients;
    //TODO FIX THE SERVICE
    private AircraftService service;
    private int[] aircraftIds;
    private int numOfAicrafts;

    public int getNumOfAicrafts() {
        return numOfAicrafts;
    }

    Logger logger= LoggerFactory.getLogger("agentManager");
    //Helper property to make this observable
    private PropertyChangeSupport support;
    @Autowired
    private AgentManager() {
        this.service= ApplicationContextUtils.getApplicationContext().getBean(AircraftService.class);
        this.numOfAicrafts=service.getAll().size();
        clients=new HashMap<>();
        aircraftIds=new int[numOfAicrafts];

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
        return clients.getOrDefault(id,null);
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

    public Map<Integer, FlightLiveValues> getAllLiveFlightsValues() {
        Map<Integer, FlightLiveValues> liveFlights=new HashMap<>();
        for (var client:clients.values()) {
            liveFlights.put(client.getId(),client.getFlightLiveValues());
        }
        return liveFlights;
    }

    public int getCountOfAgents() {
        return clients.size();
    }
}
