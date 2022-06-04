package com.flightgearserver.demo.Http.Flightsdata;

import com.flightgearserver.demo.Http.Entiteis.Flightsdatum;
import com.flightgearserver.demo.Utils.TimeSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightDataService {

    FlightdataRepository repository;

    @Autowired
    public FlightDataService(FlightdataRepository repository) {
        this.repository = repository;
    }



}
