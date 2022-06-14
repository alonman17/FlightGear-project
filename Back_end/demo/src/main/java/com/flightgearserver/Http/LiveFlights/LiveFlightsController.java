package com.flightgearserver.Http.LiveFlights;

import com.flightgearserver.liveCache.FlightLiveValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LiveFlightsController {
    LiveFlightsService service;

    @Autowired
    public LiveFlightsController(LiveFlightsService service) {
        this.service = service;
    }

    @GetMapping("api/liveFlights/{id}")
    public Map<String, Double> getFlight(@PathVariable("id") int id){
        return service.getAgentCurrentData(id);
    }

    @GetMapping("api/liveFlights/{id}/{value}")
    public Double getAgentSpecificValue(@PathVariable("id") int id,@PathVariable("value") String value){
        return service.getAgentSpecificValue(id,value);
    }
    @GetMapping("api/liveFlights/all")
    public Map<Integer, FlightLiveValues> getAllLiveFlightsValues(){
        return service.getAllLiveFlightsValues();
    }
    @PostMapping("api/liveFlights/{id}")
    public void sendDataToAgent(@PathVariable("id") int id,@RequestBody Map<String,Double> data){
        service.sendDataToAgent(id,data);
    }
    @PostMapping ("api/liveFlights/intepater/{id}")
    public void sendDataToInterpeter(@PathVariable("id") int id,@RequestBody String[] data){
        service.sendDataToInterpeter(id,data);
    }

}
