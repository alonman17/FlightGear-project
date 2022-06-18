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
    public static Socket clientSocket;

    static public volatile boolean connected;
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

                clientSocket = agentServer.accept();
                System.out
                        .println(" Flight-Gear Client connected from: " + clientSocket.getInetAddress() + " PORT: "
                                + clientSocket.getPort());
                connected = true;
                try {
                    fgClient.handleClient(new InputStreamReader(clientSocket.getInputStream()),
                            new OutputStreamWriter(clientSocket.getOutputStream()));
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
            clientSocket.close();
            agentServer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return connected;
    }
}