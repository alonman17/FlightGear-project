package com.flightgearserver.demo.Http.LiveFlights;

import com.flightgearserver.demo.Http.Entiteis.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LiveFlightsController {
    LiveFlightsService service;

    @Autowired
    public LiveFlightsController(LiveFlightsService service) {
        this.service = service;
    }

    @GetMapping("api/liveFlights/{id}")
    public String getFlight(@PathVariable("id") int id){
        return service.getAgentCurrentData(id);
    }

    @GetMapping("api/liveFlights/{id}/{value}")
    public Double getAgentSpecificValue(@PathVariable("id") int id,@PathVariable("value") String value){
        return service.getAgentSpecificValue(id,value);
    }


}
