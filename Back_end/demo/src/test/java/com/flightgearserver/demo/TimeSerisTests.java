package com.flightgearserver.demo;


import com.flightgearserver.demo.Flightsdata.FlightDataService;
import com.flightgearserver.demo.Utils.TimeSeries;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TimeSerisTests {

    @Autowired
    FlightDataService service;
    @Test
    public void testOutputToCsv(){
        TimeSeries ts=new TimeSeries("C:\\Users\\alonm\\Desktop\\FlightGear-project\\Back_end\\demo\\src\\main\\resources\\normal_flight.csv");
        ts.exportToCsv("wow.csv");

    }

    @Test
    public void testInsertFlightData(){
        TimeSeries ts= new TimeSeries("C:\\Users\\alonm\\Desktop\\FlightGear-project\\Back_end\\demo\\src\\main\\resources\\normal_flight.csv");
        service.insertTimeSeries(ts,1);

    }

}
