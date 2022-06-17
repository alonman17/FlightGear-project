package com.flightgearserver.Http.Flights;


import com.flightgearserver.Http.Entiteis.Flight;
import com.flightgearserver.Http.Entiteis.Flightsdatum;
import com.flightgearserver.Http.Flightsdata.FlightdataRepository;
import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

    public byte[] getNormalFlight()  {

        try {
            InputStream in =new FileInputStream("C:\\Users\\alonm\\Desktop\\FlightGear-project\\Back_end\\demo\\src\\main\\resources\\normal_flight.csv");
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
