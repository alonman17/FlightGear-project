package Aircraft;

import Entiteis.Aircraft;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Aircraft")
public class AircraftController {


    @GetMapping
    public List<Aircraft> getAircraft(){
        return List.of(new Aircraft((long)4,"type",0.0));
    }
}
