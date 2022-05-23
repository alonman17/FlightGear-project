package com.flightgearserver.demo.agent;


import org.aspectj.weaver.loadtime.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AgentServer {
    ServerSocket theServer;
    ThreadPoolExecutor pool;
    static volatile boolean stop;
    Logger logger= LoggerFactory.getLogger(this.getClass());
    public AgentServer() {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(10);
        pool=new ThreadPoolExecutor(10,10,5, TimeUnit.SECONDS,blockingQueue);
    }
    private void startServer(int port)  {
        try {
            theServer = new ServerSocket(port);
        } catch (IOException e) {
            logger.error("Error opening server on port: " + port);
            logger.error(e.getMessage());
        }
        logger.info("Server started on port: "+ port);
        while(!stop) {
            try {
                Socket aClient = theServer.accept();
                logger.info("Agent connected from " + aClient.getInetAddress()+":"+ aClient.getPort());
                AgentHandler agentHandler=new AgentHandler(aClient.getInputStream(),aClient.getOutputStream());
                AgentManager.getInstance().addAgent(agentHandler);
                pool.execute(()-> agentHandler.Handle());
            }
            catch (IOException e) {
                logger.error("Connection lost");
                logger.error(e.getMessage());
            }
        }
        try {
            theServer.close();
            this.stop();
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