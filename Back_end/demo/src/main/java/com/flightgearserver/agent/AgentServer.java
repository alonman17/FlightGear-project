package com.flightgearserver.agent;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class AgentServer {
    private ServerSocket theServer;
    private ExecutorService pool;
    static volatile boolean stop;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    public AgentServer() {
        pool=Executors.newFixedThreadPool(10);
    }
    private void startServer(int port)  {
        try {
            theServer = new ServerSocket(port);
        } catch (IOException e) {
            logger.error("Error opening server on port: " + port);
            logger.error(e.getMessage());
        }
        logger.info("Agent Server started on port: "+ port);
        while(!stop) {
            try {
                Socket aClient = theServer.accept();
                logger.info("Agent connected from " + aClient.getInetAddress()+":"+ aClient.getPort());
                AgentHandler agentHandler=new AgentHandler(aClient.getInputStream(),aClient.getOutputStream());
                pool.execute(()-> agentHandler.Handle());
            }
            catch (Exception e) {
                logger.error("Connection lost");
                logger.error(e.getMessage());
            }
        }
        try {
            theServer.close();
            this.stop();
            pool.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // runs the server in its own thread
    public void start(int port) {
        new Thread(()-> {
            startServer(port);
        }).start();
    }

    public void stop() {
        stop=true;
    }
}
