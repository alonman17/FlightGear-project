package com.flightgearserver.Http.statistics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StatisticsController {

   StatisticsService service;

    @Autowired
    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @GetMapping("api/statistics/aircraft/{month}/{id}")
    public double getMillagePerAircraftInSingleMonth(@PathVariable("id") int id,@PathVariable("month") int month){
        return service.getMillagePerMonthSingle(id,month);
    }

    @GetMapping("api/statistics/aircraft/all/{month}")
        public List<Map<String, Double>> getMillageAllAircraftsPerMonth(@PathVariable("month") int month){
        return service.getMillagePerMonthAll(month);
    }

    @GetMapping("api/statistics/liveFlightsCount")
    public Integer getLiveFlightsCount(){
        return service.getLiveFlightsCount();
    }

    @GetMapping("api/statistics/aircraft/{year}")
    public Map<Integer, Double> getMillageAllAircraftsPerYear(@PathVariable("year") int year){
        return service.AllMonthsAllAircrafts(year);
    }
    @GetMapping("api/statistics/fleetSize/{year}")
    public Map<Integer,Integer> getFleetSizePerMonth(@PathVariable("year") int year){
        return service.getFleetSizePerMonth(year);
    }
}
