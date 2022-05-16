package tirgul.model;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    
    private Socket client;
    public static volatile boolean stop;
    final BufferedReader in;
    final PrintWriter out;

    public ClientHandler(Socket s , BufferedReader in,PrintWriter out){
        client = s;
        this.in = in;
        this.out = out;
        stop = false;
        
    }  

    @Override
    public void run(){
        String recived;
        try{  
            while(!stop){
                
                out.println("get /controls/flight/rudder");
                recived = in.readLine();
                System.out.println(recived);  
            }
            client.close();
            System.out.println("Client Closed Connection");
         } catch (IOException e) {
         e.printStackTrace();
    }
            

    }
}
