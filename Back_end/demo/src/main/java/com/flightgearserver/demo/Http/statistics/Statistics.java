package com.flightgearserver.demo.Http.statistics;

import com.flightgearserver.demo.Http.Aircraft.AircraftService;
import com.flightgearserver.demo.Http.Entiteis.Flight;
import com.flightgearserver.demo.Http.Flights.FlightsService;
import com.flightgearserver.demo.agent.AgentManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class Statistics {

    //TODO: implement
   public static double[] getMillagePerMonthAll(List<Flight> flights, int month){
       return null;
   }
    public static double getMillagePerMonthSingle(List<Flight> flight, int month,int id){
        return 0;
    }
   public static int getLiveFlightsCount(){
       return AgentManager.getInstance().getCountOfAgents();
   }
   //TODO:think about more statistics to get
}
