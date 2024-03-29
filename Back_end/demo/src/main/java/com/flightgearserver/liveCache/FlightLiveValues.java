package com.flightgearserver.liveCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Used to manage live values from a single flight
 */
public class FlightLiveValues {
    public Map<String,Double> values;

    public FlightLiveValues() {
        this.values=new ConcurrentHashMap<>();
    }

    /**
     * Used to add all values to a map with the value of 0
     * @param valueNames array containing the value names
     */
    public void InitAllValues(String[] valueNames) {
        for (int i = 0; i < valueNames.length; i++) {
            values.put(valueNames[i],0d);
        }
    }
    public double getValue(String name){
        return values.get(name);
    }
    public void setSingleValue(String name,double value){
        values.put(name,value);
    }

    public String getAllValues() {
        StringBuilder stringBuilder=new StringBuilder();
        values.values().forEach((v)->stringBuilder.append(v+","));
        return  stringBuilder.toString();

    }
}
