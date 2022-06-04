package com.flightgearserver.demo.AnomalyDetector;

import com.flightgearserver.demo.Utils.TimeSeries;

import java.util.List;

public class ZscoreAnomalyDetector implements TimeSeriesAnomalyDetector {

    @Override
    public void learnNormal(TimeSeries ts) {

    }

    @Override
    public List<AnomalyReport> detect(TimeSeries ts) {
        return null;
    }

    @Override
    public AnomalyReport detect(TimeSeries ts, int timestamp) {
        return null;
    }
}
