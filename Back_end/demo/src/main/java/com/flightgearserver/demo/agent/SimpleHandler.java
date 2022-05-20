package com.flightgearserver.demo.agent;

import com.flightgearserver.demo.ServerScoket.ClientHandler;
import com.flightgearserver.demo.Utils.TimeSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;


public class SimpleHandler implements ClientHandler {
    PrintWriter writer;
    BufferedReader in;
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public void handleClient(Socket aClient)  {
        TimeSeries ts = new TimeSeries("1,2,3,4,5,6,7,8,9");
        try{
            writer = new PrintWriter(aClient.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(aClient.getInputStream()));
            String line = null;
            while (!(line = in.readLine()).equals("done")){
                //ts.addRow(line);
                logger.info(line);
            }
            logger.info("end of flight");
            ts.exportToCsv(new Date().toLocaleString()+".txt");
            writer.close();
                in.close();
        } catch (IOException e) {
            logger.error("CONNECTION LOST TO CLIENT");
            logger.error(e.getMessage());
            ts.exportToCsv(new Date()+".txt");
            logger.info("Thread name: " + Thread.currentThread().getName() + " has died");
        }
    }
}
