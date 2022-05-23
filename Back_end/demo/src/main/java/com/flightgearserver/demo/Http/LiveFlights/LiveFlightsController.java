package com.flightgearserver.demo.Http.LiveFlights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LiveFlightsController {
    @Autowired
    LiveFlightsService service;


}
