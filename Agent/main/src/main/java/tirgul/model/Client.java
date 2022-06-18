package tirgul.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;

public class Client {
    HashMap<String, String> properties;
    private PrintWriter out2fg;
    Socket client;

    public Client() {
        properties = new HashMap<>();
        System.out.println("Waiting For Flight-Gear Aplication To Start ... ");
        while (!AgentServer.connected)
            ;
        System.out.println();
        try {
            client = new Socket("127.0.0.1", 5402);
            out2fg = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(new File("src/main/resources/properties.txt")));

            String line;
            while ((line = br.readLine()) != null) {
                String[] sp = line.split(",");
                properties.put(sp[0], sp[1]);
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendCommand2fg(String command) {
        out2fg.println(command);
        out2fg.flush();
        System.out.println("COMMAND: " + "'" + command + "'" + " Recived.");
    }

    public void setAileron(double x) {
        String command = properties.get("aileron");
        out2fg.println(command + " " + x);
        out2fg.flush();
    }

    public void setElevators(double x) {
        String command = properties.get("elevator");
        out2fg.println(command + " " + x);
        out2fg.flush();
    }

    public void setRudder(double x) {
        String command = properties.get("rudder");
        out2fg.println(command + " " + x);
        out2fg.flush();
    }

    public void setThruttle(String x) {
        String command = properties.get("throttle");
        out2fg.println(command + " " + x);
        out2fg.flush();
    }

    public void closeConnection() {
        try {
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
