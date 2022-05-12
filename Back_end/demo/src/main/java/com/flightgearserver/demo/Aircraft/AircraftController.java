package com.flightgearserver.demo.Aircraft;

import com.flightgearserver.demo.Entiteis.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Aircraft")
public class AircraftController {
    private final AircraftService aircraftService;
    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<Aircraft> getAircrafts(){
        return aircraftService.getAll();
    }

    @PostMapping
    public void addAircraft(@RequestBody Aircraft aircraft){
        aircraftService.addAircraft(aircraft);
    }

    @GetMapping("{aircraftID}")
    public Aircraft getAircraft(@PathVariable("aircraftID") Long id){
        return aircraftService.getById(id);

    }
    @PatchMapping("{aircraftID}")
    public void updateAircraft(@PathVariable("aircraftID") Long id,@RequestParam(required = false) String type, @RequestParam(required = false) Double millage){
        aircraftService.updateById(id,type,millage);
    }
}
