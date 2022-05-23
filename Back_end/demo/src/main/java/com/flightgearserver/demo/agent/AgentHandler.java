package com.flightgearserver.demo.agent;

import com.flightgearserver.demo.Utils.TimeSeries;
import com.flightgearserver.demo.liveCache.FlightLiveValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AgentHandler {

    private TimeSeries ts;
    private FlightLiveValues flightLiveValues;
    private Scanner in;
    private PrintWriter out;

    public TimeSeries getTs() {
        return ts;
    }

    public void setTs(TimeSeries ts) {
        this.ts = ts;
    }

    public FlightLiveValues getFlightLiveValues() {
        return flightLiveValues;
    }

    public void setFlightLiveValues(FlightLiveValues flightLiveValues) {
        this.flightLiveValues = flightLiveValues;
    }

    Logger logger= LoggerFactory.getLogger(AgentHandler.class);

    public AgentHandler(InputStream in, OutputStream out) {
        this.in = new Scanner(new InputStreamReader(in));
        this.out=new PrintWriter(out);
    }

    /**
     * Used to read data from the Agent
     *
     */
    public void Handle(){
        //Runs in a new Thread to keep reading data in the background.
        logger.info("Reading data from agent");
        new Thread(()->{
            //while loop that handles data stream of the agent
            while (in.hasNext()){
                StringBuilder stringBuilder=new StringBuilder();
                String line=in.nextLine();
                //Assuming our lines comes out as valName:value,valName1:value1....
                String[] values=line.split(",");
                for (int i = 0; i < values.length; i++)
                {
                    String[] temp=values[i].split(":");
                    flightLiveValues.setSingleValue(temp[0], Double.parseDouble(temp[1]));
                    stringBuilder.append(temp[1]+",");
                }
                stringBuilder.deleteCharAt(stringBuilder.length());
                ts.addRow(stringBuilder.toString());
            }
        }).run();

    }

    public void writeToClient(String line){
        logger.info("Writing to agent : "+ line);
        out.println(line);
    }
    public void writeToClient(String[] lines){
        for (String line : lines) {
            writeToClient(line);
        }
    }

}
