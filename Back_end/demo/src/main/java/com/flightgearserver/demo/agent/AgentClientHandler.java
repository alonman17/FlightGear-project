package com.flightgearserver.demo.agent;

import com.flightgearserver.demo.ServerScoket.ClientHandler;
import com.flightgearserver.demo.Utils.TimeSeries;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AgentClientHandler implements ClientHandler {
    Scanner in;
    PrintWriter out;
    TimeSeries ts;

    /**
     * Used to handle agent connection
     * The protocol: first,the server generating plane id for the flight from the available planes. (NOTE: do we need to do it?)
     * Then, the agent will send the timeSeries column names. (NOTE: This might in the backend responsiabilty, need to think)
     * next, couple of cases:
     * Flight:
     * if the agent sends "flight" means that flight data is incoming and will be stored in TimeSeries and liveCache objects
     *
     * @param inFromClient input stream from the agent
     * @param outToClient output stream to the agent
     */
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {
        in=new Scanner(new InputStreamReader(inFromClient));
        out=new PrintWriter(new OutputStreamWriter(outToClient));
        //TODO ADD STRING ARRAY CONSTRUCTOR

        String line=null;
        //TODO need to handel cases:agent sending flight data,
        while(in.hasNext()){
            line=in.nextLine();
            //Case Flight
            if(line.equals("Flight")){
                line=in.nextLine();
                ts=new TimeSeries(line);
                //TODO Add live data sending to the front end
                while (in.hasNext()){
                    line=in.nextLine();
                    if(line.equals("done"))
                        break;
                    ts.addRow(line);
                }
            }
        }

    }

    @Override
    public void handleClient(Socket aClient) {

    }
}
