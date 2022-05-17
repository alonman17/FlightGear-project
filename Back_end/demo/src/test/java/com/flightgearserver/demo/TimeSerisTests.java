package com.flightgearserver.demo;

import com.flightgearserver.demo.Utils.TimeSeries;
import org.junit.jupiter.api.Test;



public class TimeSerisTests {


    @Test
    public void testOutputToCsv(){
        TimeSeries ts=new TimeSeries("C:\\Users\\alonm\\Desktop\\FlightGear-project\\Back_end\\demo\\src\\main\\java\\com\\flightgearserver\\demo\\test.csv");
        ts.exportToCsv("wow.csv");

    }
}
