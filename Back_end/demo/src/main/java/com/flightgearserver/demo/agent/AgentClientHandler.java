package com.flightgearserver.demo.agent;

import com.flightgearserver.demo.ServerScoket.ClientHandler;
import com.flightgearserver.demo.Utils.TimeSeries;

import java.io.*;
import java.util.Scanner;

public class AgentClientHandler implements ClientHandler {
    Scanner in;
    PrintWriter out;
    TimeSeries ts;
    @Override
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
                    ts.addRow(line);
                }
            }
        }

    }
}
