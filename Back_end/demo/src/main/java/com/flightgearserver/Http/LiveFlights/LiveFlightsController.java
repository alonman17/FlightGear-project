package com.flightgearserver.Http.LiveFlights;

import com.flightgearserver.liveCache.FlightLiveValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LiveFlightsController {
    LiveFlightsService service;

    @Autowired
    public LiveFlightsController(LiveFlightsService service) {
        this.service = service;
    }

    /**
     * used to get the live data for the agent with the given id
     * example response:
     * {
     *   "airspeed-kt": 0,
     *   "throttle1": 0,
     *   "throttle0": 0,
     *   "engine-pump1": 0,
     *   "electric-pump0": 0,
     *   "gps_indicated-vertical-speed": 0,
     *   "engine-pump0": 0,
     *   "electric-pump1": 0,
     *   "attitude-indicator_indicated-pitch-deg": 12,
     *   "encoder_indicated-altitude-ft": 0,
     *   "gps_indicated-ground-speed-kt": 0,
     *   "vertical-speed-fps": 0,
     *   "flaps": 0,
     *   "heading-deg": 180.018387,
     *   "elevator": 0,
     *   "longitude-deg": -22.6054255528,
     *   "altimeter_indicated-altitude-ft": 281.535034,
     *   "encoder_pressure-alt-ft": 0,
     *   "rudder": 0,
     *   "latitude-deg": 63.9918353378,
     *   "indicated-heading-deg": 282.893036,
     *   "aileron": 0,
     *   "roll-deg": 0,
     *   "speedbrake": 0,
     *   "external-power": 0,
     *   "slats": 0,
     *   "airspeed-indicator_indicated-speed-kt": 0,
     *   "gps_indicated-altitude-ft": 0,
     *   "vertical-speed-indicator_indicated-speed-fpm": 0,
     *   "pitch-deg": 0.424,
     *   "side-slip-deg": 0,
     *   "altimeter_pressure-alt-ft": 1.193444,
     *   "engine_rpm": 0,
     *   "glideslope": 0,
     *   "magnetic-compass_indicated-heading-deg": 0,
     *   "altitude-ft": -9999,
     *   "attitude-indicator_indicated-roll-deg": 40,
     *   "slip-skid-ball_indicated-slip-skid": 0,
     *   "APU-generator": 0,
     *   "attitude-indicator_internal-roll-deg": 0,
     *   "turn-indicator_indicated-turn-rate": 0,
     *   "attitude-indicator_internal-pitch-deg": 0
     * }
     * @param id
     * @return
     */
    @GetMapping("api/liveFlights/{id}")
    public Map<String, Double> getFlight(@PathVariable("id") int id){
        return service.getAgentCurrentData(id);
    }

    /**
     * used to get the live data for specific value with the given agent id*
     * 22.25656
     * @param id
     * @param value
     * @return
     */
    @GetMapping("api/liveFlights/{id}/{value}")
    public Double getAgentSpecificValue(@PathVariable("id") int id,@PathVariable("value") String value){
        return service.getAgentSpecificValue(id,value);
    }

    /**
     * used to get all the live data for all the agents
     * example response:
     *
     * @return
     */
    @GetMapping("api/liveFlights/all")
    public Map<Integer, FlightLiveValues> getAllLiveFlightsValues(){
        return service.getAllLiveFlightsValues();
    }
    @PostMapping("api/liveFlights/{id}")
    public void sendDataToAgent(@PathVariable("id") int id,@RequestBody Map<String,Double> data){
        //service.sendDataToAgent(id,data);
        System.out.println(id + " " + data);
    }
    @PostMapping ("api/liveFlights/intepater/{id}")
    public String sendDataToInterpeter(@PathVariable("id") int id, @RequestBody String data){
        service.sendDataToInterpeter(id,data);
        return "ok";
    }
    @GetMapping("api/liveFlights/test")
    public String test(){
        return "{\"airspeed-kt\":2.999235,\"throttle1\":0.0,\"throttle0\":0.0,\"engine-pump1\":0.0,\"electric-pump0\":0.0,\"gps_indicated-vertical-speed\":-3.4E-5,\"engine-pump0\":0.0,\"electric-pump1\":0.0,\"attitude-indicator_indicated-pitch-deg\":12.0,\"encoder_indicated-altitude-ft\":-249.999863,\"gps_indicated-ground-speed-kt\":1.0E-6,\"vertical-speed-fps\":-0.0,\"flaps\":0.0,\"heading-deg\":180.014069,\"elevator\":0.0,\"longitude-deg\":-22.6054263254,\"altimeter_indicated-altitude-ft\":142.832977,\"encoder_pressure-alt-ft\":-250.0,\"rudder\":0.0,\"latitude-deg\":63.9918362279,\"indicated-heading-deg\":282.896637,\"aileron\":0.0,\"roll-deg\":0.11408,\"speedbrake\":0.0,\"external-power\":0.0,\"slats\":0.0,\"airspeed-indicator_indicated-speed-kt\":2.534421,\"gps_indicated-altitude-ft\":146.229614,\"vertical-speed-indicator_indicated-speed-fpm\":-11.417996,\"pitch-deg\":4.952536,\"side-slip-deg\":-29.963707,\"altimeter_pressure-alt-ft\":-245.062378,\"engine_rpm\":0.0,\"glideslope\":-0.794299,\"magnetic-compass_indicated-heading-deg\":176.760712,\"altitude-ft\":146.229614,\"attitude-indicator_indicated-roll-deg\":40.0,\"slip-skid-ball_indicated-slip-skid\":-0.019903,\"APU-generator\":0.0,\"attitude-indicator_internal-roll-deg\":0.0,\"turn-indicator_indicated-turn-rate\":-2.499906,\"attitude-indicator_internal-pitch-deg\":0.0}";
    }
    @GetMapping("api/liveFlights/test/all")
    public String testall() {

        return "{\"8\":{\"values\":{\"airspeed-kt\":2.964062,\"throttle1\":0.0,\"throttle0\":0.0,\"engine-pump1\":0.0,\"electric-pump0\":0.0,\"gps_indicated-vertical-speed\":-0.00104,\"engine-pump0\":0.0,\"electric-pump1\":0.0,\"attitude-indicator_indicated-pitch-deg\":12.0,\"encoder_indicated-altitude-ft\":-249.999863,\"gps_indicated-ground-speed-kt\":0.0,\"vertical-speed-fps\":-3.0E-6,\"flaps\":0.0,\"heading-deg\":180.014069,\"elevator\":0.0,\"longitude-deg\":-22.6054263253,\"altimeter_indicated-altitude-ft\":139.488541,\"encoder_pressure-alt-ft\":-250.0,\"rudder\":0.0,\"latitude-deg\":63.991836228,\"indicated-heading-deg\":282.896637,\"aileron\":0.0,\"roll-deg\":0.113981,\"speedbrake\":0.0,\"external-power\":0.0,\"slats\":0.0,\"airspeed-indicator_indicated-speed-kt\":2.471057,\"gps_indicated-altitude-ft\":146.229599,\"vertical-speed-indicator_indicated-speed-fpm\":-13.632858,\"pitch-deg\":4.952538,\"side-slip-deg\":-29.963737,\"altimeter_pressure-alt-ft\":-248.406815,\"engine_rpm\":0.0,\"glideslope\":-0.835892,\"magnetic-compass_indicated-heading-deg\":192.628326,\"altitude-ft\":146.229599,\"attitude-indicator_indicated-roll-deg\":40.0,\"slip-skid-ball_indicated-slip-skid\":-0.019869,\"APU-generator\":0.0,\"attitude-indicator_internal-roll-deg\":0.0,\"turn-indicator_indicated-turn-rate\":-2.5,\"attitude-indicator_internal-pitch-deg\":0.0}}}";
    }
}
