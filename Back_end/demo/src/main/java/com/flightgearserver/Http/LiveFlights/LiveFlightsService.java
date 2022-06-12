package flightgearserver.Http.LiveFlights;

import flightgearserver.agent.AgentManager;
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



}
