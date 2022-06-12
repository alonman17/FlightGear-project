package flightgearserver.Http.statistics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StatisticsController {

   StatisticsService service;

    @Autowired
    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @GetMapping("api/statistics/aircraft/{month}/{id}")
    public double getMillagePerAircraftInSingleMonth(@PathVariable("id") int id,@PathVariable("month") int month){
        return service.getMillagePerMonthSingle(id,month);
    }

    @GetMapping("api/statistics/aircraft/all/{month}")
        public List<Map<String, Double>> getMillageAllAircraftsPerMonth(@PathVariable("month") int month){
        return service.getMillagePerMonthAll(month);
    }

    @GetMapping(value = "api/statistics/liveFlights")
    public Integer getLiveFlightsCount(){
        return service.getLiveFlightsCount();
    }
}
