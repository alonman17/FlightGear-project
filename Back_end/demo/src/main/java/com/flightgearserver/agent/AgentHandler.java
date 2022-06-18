package com.flightgearserver.agent;

import com.flightgearserver.Interperter.Interpreter;
import com.flightgearserver.Interperter.SharedMemory;
import com.flightgearserver.Utils.TimeSeries;
import com.flightgearserver.liveCache.FlightLiveValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.LocalTime;
import java.util.Scanner;

public class AgentHandler {

    private TimeSeries ts;
    private FlightLiveValues flightLiveValues;
    private Scanner in;
    private PrintWriter out;
    private volatile boolean stop=false;
    private int id;
    private final LocalTime startTime=LocalTime.now();
    private Thread interpreterThread;
    public SharedMemory sharedMemory = new SharedMemory();

    public Interpreter interpreter = new Interpreter(this,sharedMemory);
    public LocalTime getStartTime() {
        return startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


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
        this.flightLiveValues=new FlightLiveValues();
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
                    //Assuming our lines comes out as valName:value,valName1:value1....
                    try {
                        String[] values = line.split(",");
                        for (int i = 0; i < values.length; i++) {
                            String[] temp = values[i].split(":");
                            flightLiveValues.setSingleValue(temp[0], Double.parseDouble(temp[1]));
                            if(sharedMemory.varNameToAgentVarName.containsKey(temp[0])){
                                sharedMemory.symbolTable.get(sharedMemory.varNameToAgentVarName.get(temp[0])).setValue((float) Double.parseDouble(temp[1]));
                            }
                            stringBuilder.append(temp[1] + ",");
                        }
                        //logger.info(stringBuilder.toString());
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        ts.addRow(stringBuilder.toString());
                        stringBuilder.setLength(0);
                        //logger.info("Received data from agent: "+ line);
                    }
                    catch (Exception e){
                        logger.error("Error in reading data from agent");
                        logger.error(e.getMessage());
                        stop=true;
                    }
                }
                close();
                interpreterThread.interrupt();
                //AgentManager.getInstance().saveFlight(this);
            }).run();


    }
    public void writeToClient(String line){
        new Thread(()->{
            out.println(line);
            logger.info("Writing to agent : "+ line);
        }).run();
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
    public void interpate(String line){
        interpreterThread= new Thread(()->{
            while (!stop)
            interpreter.run(line);
        });
        interpreterThread.start();


    }
}
