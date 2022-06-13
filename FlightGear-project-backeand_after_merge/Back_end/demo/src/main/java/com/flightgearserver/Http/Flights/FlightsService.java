package flightgearserver.Http.Flights;


import flightgearserver.Http.Entiteis.Flight;
import flightgearserver.Http.Entiteis.Flightsdatum;
import flightgearserver.Http.Flightsdata.FlightdataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
