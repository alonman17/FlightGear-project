package flightgearserver.Http.LiveFlights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LiveFlightsController {
    LiveFlightsService service;

    @Autowired
    public LiveFlightsController(LiveFlightsService service) {
        this.service = service;
    }

    @GetMapping("api/liveFlights/{id}")
    public Map<String, Double> getFlight(@PathVariable("id") int id){
        return service.getAgentCurrentData(id);
    }

    @GetMapping("api/liveFlights/{id}/{value}")
    public Double getAgentSpecificValue(@PathVariable("id") int id,@PathVariable("value") String value){
        return service.getAgentSpecificValue(id,value);
    }


}
