package tirgul.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AgentServer extends Thread{

    int port;
    ServerSocket agentServer;
    Socket client;
    static public volatile boolean stop=false;

    public AgentServer(int port){
        this.port = port;
        client = null;
    }

    @Override
    public void run(){

        while(!stop){

            try {

                agentServer = new ServerSocket(this.port);
                client = agentServer.accept();

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out  = new PrintWriter(client.getOutputStream());
                Thread t = new ClientHandler(client,inFromClient,out);

                t.start();
                
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}