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
    private volatile boolean stop=false;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
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
        id=AgentManager.getInstance().addAgent(this);
        this.in = new Scanner(new BufferedInputStream(in));
        this.out=new PrintWriter(out,true);
        ts=new TimeSeries("src/main/resources/symbol.txt");
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

                while (!stop&&in.hasNext()){
                    StringBuilder stringBuilder=new StringBuilder();
                    String line=in.nextLine();

                    ts.addRow(line);
                    //Assuming our lines comes out as valName:value,valName1:value1....
//                    String[] values=line.split(",");
//                    for (int i = 0; i < values.length; i++)
//                    {
//                        String[] temp=values[i].split(":");
//                        flightLiveValues.setSingleValue(temp[0], Double.parseDouble(temp[1]));
//                        stringBuilder.append(temp[1]+",");
//                    }
//                    stringBuilder.deleteCharAt(stringBuilder.length());
//                    ts.addRow(stringBuilder.toString());
                    logger.info("Received data from agent: "+ line);
                }
                close();
            }).run();
            ts.exportToCsv("test.csv");
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
    public void close(){
        stop=true;
        in.close();
        out.close();
        AgentManager.getInstance().removeAgent(id);
    }

}
