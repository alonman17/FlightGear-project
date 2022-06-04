package com.flightgearserver.demo.AnomalyDetector;

import com.flightgearserver.demo.Utils.TimeSeries;

import java.util.List;

public interface TimeSeriesAnomalyDetector {
	void learnNormal(TimeSeries ts);
	List<AnomalyReport> detect(TimeSeries ts);
	AnomalyReport detect(TimeSeries ts, int timestamp);
}
