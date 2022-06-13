package flightgearserver.Http.statistics;


import main.java.com.flightgearserver.Http.Entiteis.Flight;
import flightgearserver.agent.AgentManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    //TODO: implement
   public static List<Map<String, Double>> getMillagePerMonthAll(List<Flight> flights, int month){
       List<Map<String,Double>> list=new ArrayList<>();
       flights.stream().filter(f -> f.getDate().getMonthValue() == month).forEach(f->{
           Map<String,Double> x=new HashMap<>();
           x.put("aircraftid", Double.valueOf(f.getAircraftid()));
           x.put("millagedone",f.getMilagedone());
       });
       return list;
   }
    public static double getMillagePerMonthSingle(List<Flight> flights, int month,int id){
        return flights.stream().filter(f->f.getAircraftid().intValue()==id).filter(f->f.getDate().getMonthValue()==month).mapToDouble(f->f.getMilagedone()).sum();
    }
   public static int getLiveFlightsCount(){
       return AgentManager.getInstance().getCountOfAgents();
   }
   //TODO:think about more statistics to get
}
