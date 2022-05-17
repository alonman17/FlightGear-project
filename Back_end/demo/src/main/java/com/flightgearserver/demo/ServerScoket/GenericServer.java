package com.flightgearserver.demo.ServerScoket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GenericServer {
    ServerSocket theServer;
    ThreadPoolExecutor pool;
    volatile boolean stop;
    BlockingQueue blockingQueue;
    ClientHandler clientHandler;
    Logger logger= LoggerFactory.getLogger(this.getClass());
    public GenericServer() {
        blockingQueue=new ArrayBlockingQueue(10);
        pool=new ThreadPoolExecutor(2,10,5, TimeUnit.SECONDS,blockingQueue);
    }


    private void startServer(int port, ClientHandler clientHandler) throws IOException {
        theServer = new ServerSocket(port);
        logger.info("Server started on port: "+ port);
        while(!stop) {
            try {
                Socket aClient = theServer.accept();
                logger.info("input from :"+ aClient.getInetAddress());
                pool.execute(()-> {
                    try {
                        clientHandler.handleClient(aClient.getInputStream(),aClient.getOutputStream());
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
    public void start(int port,ClientHandler clientHandler) {
        this.clientHandler=clientHandler;
        new Thread(()-> {
            try {
                startServer(port,clientHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void stop() {
        stop=true;
    }
}
