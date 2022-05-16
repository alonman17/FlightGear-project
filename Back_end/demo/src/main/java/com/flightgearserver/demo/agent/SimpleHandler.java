package com.flightgearserver.demo.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


public class SimpleHandler implements ClientHandler{
    PrintWriter writer;
    BufferedReader in;
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public void handleClient(InputStream inFromClient, OutputStream outToClient) {
        writer=new PrintWriter(outToClient,true);
        in=new BufferedReader(new InputStreamReader(inFromClient));
        writer.println("Welcome and bye bye!");
        writer.println("sleeping for 1 min");
        //writer.println("set controls/flight/rudder 1");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writer.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Thread name: " + Thread.currentThread().getName() + " has died");
    }
}
