package com.flightgearserver.demo.ServerScoket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class GenericServer {
    ServerSocket theServer;
    ThreadPoolExecutor pool;
    static volatile boolean stop;
    BlockingQueue blockingQueue;
    ClientHandler clientHandler;
    Logger logger= LoggerFactory.getLogger(this.getClass());
    public GenericServer() {
        blockingQueue=new ArrayBlockingQueue(10);
        pool=new ThreadPoolExecutor(10,10,5, TimeUnit.SECONDS,blockingQueue);
    }


    private void startServer(int port, ClientHandler clientHandler)  {
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
                logger.info("Client connected from " + aClient.getInetAddress()+":"+ aClient.getPort());
                pool.execute(()-> {
                    try {
                        clientHandler.handleClient(aClient);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            catch (IOException e) {
                logger.error("Connection lost");
                logger.error(e.getMessage());
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
            startServer(port,clientHandler);
        }).start();
    }

    public void stop() {
        stop=true;
    }
}
