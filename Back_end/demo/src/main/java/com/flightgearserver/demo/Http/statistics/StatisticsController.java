package com.flightgearserver.demo.Http.statistics;


import com.flightgearserver.demo.Http.Entiteis.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StatisticsController {

    StatisticsService service;

    @Autowired
    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @GetMapping("api/statistics/aircraft/{id}/{month}")
    public double getMillagePerAircraftInSingleMonth(@PathVariable("id") int id,@PathVariable("month") int month){
        return service.getMillagePerMonthSingle(id,month);
    }

    @GetMapping("api/statistics/aircraft/all/{month}")
        public double[] getMillageAllAircraftsPerMonth(@PathVariable("month") int month){
        return service.getMillagePerMonthAll(month);
    }

    @GetMapping("api/statistics/liveFlights")
    public int getLiveFlightsCount(){
        return service.getLiveFlightsCount();
    }
}
