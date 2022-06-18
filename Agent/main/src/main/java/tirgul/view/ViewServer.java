package tirgul.view;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import tirgul.model.FgClientHandler;

public class ViewServer {

    ServerSocket viewServer;
    Socket client;
    Scanner scanner;
    PrintWriter out;
    FgClientHandler fgClient;
    int port;
    private volatile boolean stop = false;

    public ViewServer(int port) {
        this.port = port;
        fgClient = new FgClientHandler();
    }

    public void startServer() {
        try {

            viewServer = new ServerSocket(port);
            System.out.println("Back End Server is listening on PORT : 5000");
            try {
                while (!stop) {

                    client = viewServer.accept();
                    System.out.println("Client Has Connected To BackendServer From: " + client.getPort());
                    scanner = new Scanner(new InputStreamReader(client.getInputStream()));
                    out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
                    new Thread(() -> fgClient.writeToCsv(scanner, out, "Agent/main/src/main/resources/BackendCSV.txt"))
                            .start();
                }

            } catch (SocketException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
