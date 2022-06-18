package com.flightgearserver.Http.statistics;


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

    /**
     * used to get the millage that aircraft id has flown in the given month
     * example response:
     * {
     *    500 //plain number and not a json object
     *  }
     * @param id
     * @param month
     * @return
     */
    @GetMapping("api/statistics/aircraft/{month}/{id}")
    public double getMillagePerAircraftInSingleMonth(@PathVariable("id") int id,@PathVariable("month") int month){
        return service.getMillagePerMonthSingle(id,month);
    }

    /**
     * used to get the millage that all aircrafts have flown in the given month
     * example response:
     *
     *      [
    *           {
     *              aircraftId: id,
     *              millagedone: millage(number)
     *          }
     *      ]
     *
     * @param month
     * @return
     */
    @GetMapping("api/statistics/aircraft/all/{month}")
        public List<Map<String, Double>> getMillageAllAircraftsPerMonth(@PathVariable("month") int month){
        return service.getMillagePerMonthAll(month);
    }

    /**
     * used to get the number of live flights
     * example response:
     * {
     *  1
     * }
     * @return
     */
    @GetMapping("api/statistics/liveFlightsCount")
    public Integer getLiveFlightsCount(){
        return service.getLiveFlightsCount();
    }

    /**
     * used to get the millage per month for all aircrafts for a given year
     * example response:
     * {
     *   "1": 0.0,
     *   "2": 0.0,
     *   "3": 0.0,
     *   "4": 0.0,
     *   "5": 0.0,
     *   "6": 0.0028126483769211107,
     *   "7": 0.0,
     *   "8": 0.0,
     *   "9": 0.0,
     *   "10": 0.0,
     *   "11": 0.0,
     *   "12": 0.0
     * }
     * @param year
     * @return
     */
    @GetMapping("api/statistics/aircraft/{year}")
    public Map<Integer, Double> getMillageAllAircraftsPerYear(@PathVariable("year") int year){
        return service.AllMonthsAllAircrafts(year);
    }

    /**
     * used to get the fleet size per month for all aircrafts for a given year
     * example response:
     * {
     *   "1": 0,
     *   "2": 1,
     *   "3": 2,
     *   "4": 2,
     *   "5": 3,
     *   "6": 4,
     *   "7": 4,
     *   "8": 4,
     *   "9": 5,
     *   "10": 6,
     *   "11": 6,
     *   "12": 7
     * }
     * @param year
     * @return
     */
    @GetMapping("api/statistics/fleetSize/{year}")
    public Map<Integer,Integer> getFleetSizePerMonth(@PathVariable("year") int year){
        return service.getFleetSizePerMonth(year);
    }
}
