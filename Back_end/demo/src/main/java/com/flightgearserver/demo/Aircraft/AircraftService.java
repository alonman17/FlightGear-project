package com.flightgearserver.demo.Aircraft;

import com.flightgearserver.demo.Entiteis.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAll(){
        return aircraftRepository.findAll();
    }

    public void addAircraft(Aircraft aircraft){
        aircraftRepository.save(aircraft);
        System.out.println(aircraft);
    }

    public Aircraft getById(Long id){
        System.out.println(id);
        if(!aircraftRepository.existsById(id)){
            throw new IllegalStateException("student with id " + id+ " doesnt exist");
        }
        return(aircraftRepository.findById(id).get());

    }
    @Transactional
    public void updateById(Long id,String type,double millage){
        Aircraft old=aircraftRepository.findById(id).orElseThrow(()->
            new IllegalStateException("id doesnt exist")
        );
        old.setMillage(millage);
        old.setType(type);
    }
}
