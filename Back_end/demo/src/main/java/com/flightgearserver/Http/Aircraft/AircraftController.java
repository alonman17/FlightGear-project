package flightgearserver.Http.Aircraft;

import flightgearserver.Http.Entiteis.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AircraftController {

    AircraftService service;

    @Autowired
    public AircraftController(AircraftService service) {
        this.service = service;
    }

    @GetMapping("api/aircraft/{id}")
    public Aircraft getAircraft(@PathVariable("id") int id){
        return service.getAircraft(id);
    }

    @GetMapping("api/aircraft/all")
    public List<Aircraft> getAllAircraft(){
        return service.getAll();
    }


}
