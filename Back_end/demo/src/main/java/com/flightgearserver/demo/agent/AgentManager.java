package com.flightgearserver.demo.agent;

import com.flightgearserver.demo.Http.Aircraft.AircraftService;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to manage all the agents.
 */

public class AgentManager {
    private static AgentManager manager;
    private Map<Integer, AgentHandler> clients;
    //TODO FIX THE SERVICE
    private AircraftService service;
    private int[] aircraftIds;

    private AgentManager() {
        clients=new HashMap<>();

        aircraftIds=new int[10];
    }

    public static AgentManager getInstance(){
        if(manager==null){
            manager=new AgentManager();
        }
        return manager;
    }

    public void addAgent(AgentHandler agent){
        int id=findFreeAircraft();
        clients.put(id,agent);
    }

    private int findFreeAircraft(){
        for (int i = 0; i < aircraftIds.length; i++) {
            if(aircraftIds[i]==0){
                aircraftIds[i]=1;
                return i+1;
            }
        }
        return -1;
    }
    public AgentHandler getAgent(int id){
        return clients.get(id);
    }
}
