package com.flightgearserver.demo;

import com.flightgearserver.demo.Interperter.Interpreter;
import com.flightgearserver.demo.Javafx.BackendApplication;
import com.flightgearserver.demo.agent.AgentHandler;
import com.flightgearserver.demo.agent.AgentServer;
import com.flightgearserver.demo.liveCache.FlightLiveValues;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws FileNotFoundException {
        //SpringApplication.run(DemoApplication.class, args);

//        Application.launch(BackendApplication.class,args);
        File file = new File("output.txt");
        FileOutputStream fout = new FileOutputStream(file);
        FlightLiveValues liveFlightLiveValues = new FlightLiveValues();
        AgentHandler agentHandler = new AgentHandler(InputStream.nullInputStream(),fout );
        agentHandler.setFlightLiveValues(liveFlightLiveValues);
        agentHandler.getFlightLiveValues().setSingleValue("brakes" , 1.0);
        agentHandler.getFlightLiveValues().setSingleValue("throttle" , 1.0);
        agentHandler.getFlightLiveValues().setSingleValue("airspeed" , 1.0);
        agentHandler.getFlightLiveValues().setSingleValue("roll" , 1.0);
        agentHandler.getFlightLiveValues().setSingleValue("pitch" , 1.0);
        agentHandler.getFlightLiveValues().setSingleValue("rudder" , 1.0);
        agentHandler.getFlightLiveValues().setSingleValue("aileron" , 1.0);
        agentHandler.getFlightLiveValues().setSingleValue("elevator" , 1.0);
        agentHandler.getFlightLiveValues().setSingleValue("alt" , 1.0);
        agentHandler.getFlightLiveValues().setSingleValue("heading" , 1.0);


        agentHandler.interpreter.run(
                "var brakes = bind /controls/flight/speedbrake \n " +
                " var throttle = bind /controls/engines/engine/throttle \n " +
                " var heading = bind /instrumentation/heading-indicator/offset-deg \n " +
                " var airspeed = bind /instrumentation/airspeed-indicator/indicated-speed-kt \n " +
                " var roll = bind /instrumentation/attitude-indicator/indicated-roll-deg \n " +
                " var pitch = bind /instrumentation/attitude-indicator/internal-pitch-deg \n " +
                " var rudder = bind /controls/flight/rudder \n " +
                " var aileron = bind /controls/flight/aileron \n " +
                " var elevator = bind /controls/flight/elevator \n " +
                " var alt = bind /instrumentation/altimeter/indicated-altitude-ft \n " +
                " brakes = 0 \n " +
                " throttle = 1 \n " +
                " var h0 = heading \n " +
                " while alt < 1000 { \n " +
                " rudder = ( h0 – heading ) / 20 \n " +
                " aileron =  roll / -70 \n " +
                " elevator = pitch / 50 \n " +
                "alt = alt + 400 \n " +
                " print alt \n " +
                " sleep 250 \n " +
                " } \n " +
                " print done \n ");

    }

}
