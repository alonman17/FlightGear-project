package com.flightgearserver.Http.Aircraft;

import com.flightgearserver.Http.Entiteis.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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

    public Aircraft getAircraft(long id) {
        return repository.findById(id).get();
    }

    public void save(Aircraft aircraft) {
        repository.save(aircraft);
    }
}
