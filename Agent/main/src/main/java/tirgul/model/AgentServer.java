package tirgul.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class AgentServer {

    int port;
    FgClientHandler fgClient;
    ServerSocket agentServer;
    Socket client;

    public boolean connected;
    static public volatile boolean stop = false;

    public AgentServer() {
        fgClient = new FgClientHandler();
        connected = false;
    }

    public void startServer(int port) {
        stop = false;
        try {

            agentServer = new ServerSocket(port);
            System.out.println("Server is running on port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (!stop) {

                client = agentServer.accept();
                System.out
                        .println("Client is connected from: " + client.getInetAddress() + " PORT: " + client.getPort());
                connected = true;
                try {
                    fgClient.handleClient(new InputStreamReader(client.getInputStream()),
                            new OutputStreamWriter(client.getOutputStream()), client);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        stop = true;
        try {
            client.close();
            agentServer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return connected;
    }
}