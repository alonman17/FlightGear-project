package com.flightgearserver.demo.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {

    AircraftRepository repository;
    @Autowired
    public AircraftService(AircraftRepository repository) {
        this.repository = repository;
    }

}
