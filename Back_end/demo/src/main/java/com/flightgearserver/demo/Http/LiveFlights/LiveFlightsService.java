package com.flightgearserver.demo.Http.LiveFlights;

import com.flightgearserver.demo.Utils.TimeSeries;
import com.flightgearserver.demo.agent.AgentManager;
import org.springframework.stereotype.Service;

@Service
public class LiveFlightsService {
    AgentManager manager=AgentManager.getInstance();

    public String getAgentCurrentData(int id){
        return manager.getAgent(id).getFlightLiveValues().getAllValues();
    }

    public String getAgentTimeSeriesAsString(int id){
        return manager.getAgent(id).getTs().exportToString();
    }
    public Double getAgentSpecificValue(int id,String value){
        return  manager.getAgent(id).getFlightLiveValues().getValue(value);
    }

}
