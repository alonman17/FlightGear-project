package com.flightgearserver.Http.Flightsdata;

import com.flightgearserver.Http.Entiteis.Flightsdatum;
import com.flightgearserver.Utils.TimeSeries;
import com.opencsv.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@Service
public class FlightDataService {

    FlightdataRepository repository;

    @Autowired
    public FlightDataService(FlightdataRepository repository) {
        this.repository = repository;
    }

    public void saveTsToDB(TimeSeries ts,int flightid){
        long time=System.currentTimeMillis();
        ts.exportToCsv(time+".csv");
        Scanner csv=null;
        try {
            csv=new Scanner(new FileReader("src/main/resources/"+time+".csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CSVParser parser = new CSVParser();
        //skip the first line of the parameters
        csv.next();
        int i=0;
        while(csv.hasNext()){
            String line=csv.next();
            String[] values=null;
            try {
                values=parser.parseLine(line);
                Flightsdatum fd=new Flightsdatum(values,i,flightid);
                repository.save(fd);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        csv.close();
    }

}
