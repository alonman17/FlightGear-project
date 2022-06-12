package flightgearserver.Http.statistics;

import main.java.com.flightgearserver.Http.Flights.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {


    FlightsService flightsService;

    @Autowired
    public StatisticsService(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    public List<Map<String, Double>> getMillagePerMonthAll(int month){
        return Statistics.getMillagePerMonthAll(flightsService.getAllFlights(),month);
    }

    public double getMillagePerMonthSingle(int id,int month){
        return Statistics.getMillagePerMonthSingle(flightsService.getAllFlights(),month,id);
    }
    public int getLiveFlightsCount(){
        return Statistics.getLiveFlightsCount();
    }
}
