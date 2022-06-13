package flightgearserver.agent;

import flightgearserver.ServerScoket.ClientHandler;
import flightgearserver.Utils.TimeSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class SimpleHandler implements ClientHandler {
    PrintWriter writer;
    Scanner in;
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public void handleClient(Socket aClient)  {
        TimeSeries ts = new TimeSeries("1,2,3,4,5,6,7,8,9");
        try{
            writer = new PrintWriter(aClient.getOutputStream(), true);
            in = new Scanner(new InputStreamReader(aClient.getInputStream()));
            String line = null;
            while (in.hasNext()){
                line=in.nextLine();
                //ts.addRow(line);
                logger.info(line);
            }
            if (!aClient.isConnected()){
                logger.error("CONNECTION LOST TO AGENT");
            }
            logger.info("end of flight");
            ts.exportToCsv(String.valueOf(new Date().getTime())+".txt");
            writer.close();
                in.close();
        } catch (IOException e) {


            logger.info("Thread name: " + Thread.currentThread().getName() + " has died");
        }
    }
}
