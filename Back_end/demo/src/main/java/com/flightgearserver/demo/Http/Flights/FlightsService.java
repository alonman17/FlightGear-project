package com.flightgearserver.demo.Http.Flights;


import com.flightgearserver.demo.Http.Entiteis.Flight;
import com.flightgearserver.demo.Http.Entiteis.Flightsdatum;
import com.flightgearserver.demo.Http.Flightsdata.FlightdataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FlightsService {
    FlightsRepository flightsRepository;
    FlightdataRepository flightdataRepository;
    @Autowired
    public FlightsService(FlightsRepository flightsRepository, FlightdataRepository flightdataRepository) {
        this.flightsRepository = flightsRepository;
        this.flightdataRepository = flightdataRepository;
    }


    public List<Flight> getAllFlights(){
        return flightsRepository.findAll();
    }


    public Flight getFlight( Long id){
        return flightsRepository.findById(id).orElse(new Flight());
    }

    public List<Flightsdatum> getFightData(Long id){
        return flightdataRepository.findAllFlightData(id);
    }

    public List<Flightsdatum> getData(){
        return flightdataRepository.findAll();
    }
}
