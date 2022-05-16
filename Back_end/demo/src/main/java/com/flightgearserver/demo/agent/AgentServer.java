package com.flightgearserver.demo.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AgentServer {
    ServerSocket theServer;
    ThreadPoolExecutor pool;
    volatile boolean stop;
    BlockingQueue blockingQueue;
    Logger logger= LoggerFactory.getLogger(this.getClass());
    public AgentServer() {
        blockingQueue=new ArrayBlockingQueue(10);
        pool=new ThreadPoolExecutor(2,10,5000, TimeUnit.SECONDS,blockingQueue);
    }


    private void startServer(int port) throws IOException {
        theServer = new ServerSocket(port);
        logger.info("Server started on port: "+ port);
        while(!stop) {
            try {
                Socket input = theServer.accept();
                Socket output=new Socket("localhost",5403);
                PrintWriter writer=new PrintWriter(output.getOutputStream());
                writer.println("set controls/flight/rudder 1");
                logger.info("input from :"+ output.getInetAddress());
                pool.execute(()-> {
                    try {
                        ClientHandler ch=new SimpleHandler();
                        ch.handleClient(output.getInputStream(),input.getOutputStream());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            catch (IOException e) {
            }
        }
        try {
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // runs the server in its own thread
    public void start(int port) {

        new Thread(()-> {
            try {
                startServer(port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void stop() {
        stop=true;
    }
}
