package com.flightgearserver.demo.Http.statistics;

import com.flightgearserver.demo.Http.Entiteis.Flight;
import com.flightgearserver.demo.Http.Flights.FlightsService;
import com.flightgearserver.demo.agent.AgentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {


    FlightsService flightsService;

    @Autowired
    public StatisticsService(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    public double[] getMillagePerMonthAll(int month){
        return Statistics.getMillagePerMonthAll(flightsService.getAllFlights(),month);
    }

    public double getMillagePerMonthSingle(int month,int id){
        return Statistics.getMillagePerMonthSingle(flightsService.getAllFlights(),month,id);
    }
    public int getLiveFlightsCount(){
        return Statistics.getLiveFlightsCount();
    }
}
