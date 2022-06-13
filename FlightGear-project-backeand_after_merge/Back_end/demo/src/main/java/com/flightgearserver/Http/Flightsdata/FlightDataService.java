package flightgearserver.Http.Flightsdata;

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
