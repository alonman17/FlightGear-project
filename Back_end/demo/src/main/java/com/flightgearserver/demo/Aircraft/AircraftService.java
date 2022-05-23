package com.flightgearserver.demo.Aircraft;

import com.flightgearserver.demo.Entiteis.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AircraftService {

    AircraftRepository repository;
    @Autowired
    public AircraftService(AircraftRepository repository) {
        this.repository = repository;
    }

    public List<Aircraft> getAll() {
        return repository.findAll();
    }
}
