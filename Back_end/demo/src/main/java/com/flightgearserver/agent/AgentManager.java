package com.flightgearserver.agent;

import com.flightgearserver.ApplicationContextUtils;
import com.flightgearserver.Http.Aircraft.AircraftService;
import com.flightgearserver.Http.Entiteis.Flight;
import com.flightgearserver.Http.Flights.FlightsService;
import com.flightgearserver.Http.Flightsdata.FlightDataService;
import com.flightgearserver.Utils.Location;
import com.flightgearserver.Utils.TimeSeries;
import com.flightgearserver.liveCache.FlightLiveValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Used to manage all the agents.
 */
@Configurable
public class AgentManager {
    private static AgentManager manager;
    private Map<Integer, AgentHandler> clients;
    //TODO FIX THE SERVICE
    private AircraftService aircraftService;
    private FlightDataService flightDataService;
    private FlightsService flightsService;
    private int[] aircraftIds;
    private int numOfAicrafts;

    public int getNumOfAicrafts() {
        return numOfAicrafts;
    }

    Logger logger= LoggerFactory.getLogger("agentManager");
    //Helper property to make this observable
    private PropertyChangeSupport support;
    @Autowired
    private AgentManager() {
        this.aircraftService= ApplicationContextUtils.getApplicationContext().getBean(AircraftService.class);
        this.flightDataService= ApplicationContextUtils.getApplicationContext().getBean(FlightDataService.class);
        this.flightsService= ApplicationContextUtils.getApplicationContext().getBean(FlightsService.class);
        this.numOfAicrafts=aircraftService.getAll().size();
        //this.numOfAicrafts=10;
        clients=new HashMap<>();
        aircraftIds=new int[numOfAicrafts];

        support=new PropertyChangeSupport(this);
    }

    public static AgentManager getInstance(){
        if(manager==null){
            manager=new AgentManager();
        }
        return manager;
    }

    public int addAgent(AgentHandler agent){
        int id=findFreeAircraft();
        logger.info("Aircraft " + id + " just went online");
        clients.put(id,agent);
        return id;
    }

    private int findFreeAircraft(){
        Random random=new Random();
        for (int i = 0; i < aircraftIds.length; i++) {
                int x=random.nextInt(numOfAicrafts);
                if(aircraftIds[x]==1) {
                    continue;
                }
                support.firePropertyChange(String.valueOf(x),0,1);
                aircraftIds[x]=1;
                return x;
            }
        return -1;
    }
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
    public AgentHandler getAgent(int id){
        return clients.getOrDefault(id,null);
    }

    public void removeAgent(int id) {
        if(clients.containsKey(id)){
            var client=clients.get(id);
            clients.remove(id);
            client.close();
            logger.info("Aircraft " + id + " just went offline");
            aircraftIds[id]=0;
            support.firePropertyChange(String.valueOf(id),1,0);
        }
    }

    public Map<Integer, FlightLiveValues> getAllLiveFlightsValues() {
        Map<Integer, FlightLiveValues> liveFlights=new HashMap<>();
        for (var client:clients.values()) {
            liveFlights.put(client.getId(),client.getFlightLiveValues());
        }
        return liveFlights;
    }

    public int getCountOfAgents() {
        return clients.size();
    }

    public void saveFlight(AgentHandler agentHandler) {
        double milagedone=0;
        var lon=agentHandler.getTs().getColByName("longitude-deg");
        var lat=agentHandler.getTs().getColByName("latitude-deg");
        //caulate milage every 100 timestamps
        Location lastLocation=new Location(lat.get(0),lon.get(0));
        for (int i = 100; i < lat.size(); i+=100) {
            milagedone+=(Location.distance(lastLocation,new Location(lat.get(i),lon.get(i)))/1000);
        }
        logger.info("Milage done: " + milagedone);
        flightsService.save(new Flight(agentHandler.getStartTime(), LocalTime.now(), LocalDate.now(),lat.get(0) + " " + lon.get(0),lat.get(lat.size()-1) + " " +lon.get(lon.size()-1),agentHandler.getId()+1,milagedone));
        var aircraft=aircraftService.getAircraft(agentHandler.getId()+1);
        aircraft.setMillage(aircraft.getMillage()+milagedone);
        aircraftService.save(aircraft);
        flightDataService.saveTsToDB(agentHandler.getTs(), Math.toIntExact(flightsService.getAllFlights().get(flightsService.getAllFlights().size() - 1).getId()));
    }
}
