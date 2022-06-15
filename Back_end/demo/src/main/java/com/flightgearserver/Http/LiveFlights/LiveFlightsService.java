package com.flightgearserver.Http.LiveFlights;

import com.flightgearserver.agent.AgentManager;
import com.flightgearserver.liveCache.FlightLiveValues;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LiveFlightsService {
    AgentManager manager=AgentManager.getInstance();

    public Map<String, Double> getAgentCurrentData(int id){
        var x=manager.getAgent(id);
                if(x!=null){
                        return x.getFlightLiveValues().values;
                }
                return null;
    }

    public String getAgentTimeSeriesAsString(int id){
        return manager.getAgent(id).getTs().exportToString();
    }
    public Double getAgentSpecificValue(int id,String value){
        var x=manager.getAgent(id);
        if(x!=null){
            return x.getFlightLiveValues().getValue(value);
        }
        return null;
    }


    public Map<Integer, FlightLiveValues> getAllLiveFlightsValues() {
        return manager.getAllLiveFlightsValues();
    }

    public void sendDataToAgent(int id, Map<String, Double> data) {
        StringBuilder sb=new StringBuilder();
        for(var x:data.entrySet()){
            sb.append(x.getKey()+":"+x.getValue()+",");
        }
        sb.deleteCharAt(sb.length()-1);
        manager.getAgent(id).writeToClient(sb.toString());
    }
    //TODO: implement this
    public void sendDataToInterpeter(int id, String[] data) {

    }
}
