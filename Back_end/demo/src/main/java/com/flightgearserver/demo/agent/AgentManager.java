package com.flightgearserver.demo.agent;

import com.flightgearserver.demo.Aircraft.AircraftService;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to manage all the agents.
 */

public class AgentManager {
    private static AgentManager manager;
    private Map<Integer, Agent> clients;
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

    public void addAgent(Agent agent){
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
    public Agent getAgent(int id){
        return clients.get(id);
    }
}
