package com.flightgearserver.demo.Http.Flightsdata;

import com.flightgearserver.demo.Http.Entiteis.Flightsdatum;
import com.flightgearserver.demo.Utils.TimeSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightDataService {

    FlightdataRepository repository;

    @Autowired
    public FlightDataService(FlightdataRepository repository) {
        this.repository = repository;
    }

    public void insertTimeSeries(TimeSeries ts, int flightid) {
        for (int j = 0; j < ts.getData().get(0).size(); j++) {
            double[] arr = new double[ts.getNumberOfCols()];

            for (int i = 0; i < ts.getNumberOfCols(); i++){

                for (int k = 0; k < ts.getNumberOfCols(); k++) {
                    arr[k] = ts.getData().get(k).get(j);
                }

            }
            Flightsdatum row = new Flightsdatum(arr, flightid,j);
            repository.save(row);
            System.out.println(j);
        }
    }
}
