package com.flightgearserver.Http.Flights;


import com.flightgearserver.Http.Entiteis.Flight;
import com.flightgearserver.Http.Entiteis.Flightsdatum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightsController {

    FlightsService service;
    @Autowired
    public FlightsController(FlightsService service) {
        this.service = service;
    }

    @GetMapping("api/flights/all")
    public List<Flight> getAllFlights(){
        return service.getAllFlights();
    }
    @GetMapping("api/flights/{id}")
    public Flight getFlight(@PathVariable("id") Long id){
        return service.getFlight(id);
    }
    @GetMapping("api/flights/data/{id}")
    public List<Flightsdatum> getFightData(@PathVariable("id") Long id) {
        return service.getFightData(id);
    }
    @GetMapping(value ="api/flights/normalFlight" ,produces = "text/csv")
    public @ResponseBody byte[] getNormalFlight() {
        return service.getNormalFlight();
    }
}