package com.flightgearserver.Http.statistics;


import com.flightgearserver.Http.Entiteis.Aircraft;
import com.flightgearserver.Http.Entiteis.Flight;
import com.flightgearserver.agent.AgentManager;


import java.time.temporal.TemporalField;
import java.util.*;

public class Statistics {

    //TODO: implement
   public static List<Map<String, Double>> getMillagePerMonthAll(List<Flight> flights, int month){
       List<Map<String,Double>> list=new ArrayList<>();
       flights.stream().filter(f -> f.getDate().getMonthValue() == month).sorted((f1,f2)-> (int) (f1.getId()-f2.getId())).forEach(f->{
           Map<String,Double> x=new HashMap<>();
           x.put("aircraftid", Double.valueOf(f.getAircraftid()));
           x.put("millagedone",f.getMilagedone());
           list.add(x);
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


    public static Map<Integer,Double> AllMonthsAllAircrafts(List<Flight> flights, int year){
        Map<Integer,Double> map=new HashMap<>();
        for(int i=1;i<=12;i++){
            map.put(i,getMillagePerMonthAll(flights,i).stream().mapToDouble(m->m.get("millagedone")).sum()/AgentManager.getInstance().getNumOfAicrafts());
        }
        return map;
    }
    public static Map<Integer,Integer> AccumulatingAircraftsPerMonth(List<Aircraft> aircrafts, int year) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            int finalI = i;
            map.put(i, (int) (map.getOrDefault(i - 1, 0) + aircrafts.stream().filter(a -> Date.from(a.getDateadded()).getMonth()+1 == finalI).count()));
        }
        return map;
    }
}
