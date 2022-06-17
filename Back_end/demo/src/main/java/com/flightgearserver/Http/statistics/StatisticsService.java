package com.flightgearserver.Http.statistics;


import com.flightgearserver.Http.Aircraft.AircraftService;
import com.flightgearserver.Http.Flights.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {


    FlightsService flightsService;
    AircraftService aircraftService;
    @Autowired
    public StatisticsService(FlightsService flightsService, AircraftService aircraftService) {
        this.flightsService = flightsService;
        this.aircraftService = aircraftService;
    }

    public List<Map<String, Double>> getMillagePerMonthAll(int month){
        return Statistics.getMillagePerMonthAll(flightsService.getAllFlights(),month);
    }

    public double getMillagePerMonthSingle(int id,int month){
        return Statistics.getMillagePerMonthSingle(flightsService.getAllFlights(),month,id);
    }
    public int getLiveFlightsCount(){
        return Statistics.getLiveFlightsCount();
    }
    public Map<Integer, Double> AllMonthsAllAircrafts(int year){
        return Statistics.AllMonthsAllAircrafts(flightsService.getAllFlights(),year);
    }
    public Map<Integer,Integer> getFleetSizePerMonth(int year){
        return Statistics.AccumulatingAircraftsPerMonth(aircraftService.getAll(),year);
    }
}
