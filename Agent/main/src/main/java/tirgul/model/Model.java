package tirgul.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Model extends Observable {

    HashMap<String, String> properties;
    Socket fg;
    PrintWriter out2fg;


    public Model(String fileName) {

        properties = new HashMap<>();
        Thread t = new AgentServer(8080);
        t.start();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
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


        int port = Integer.parseInt(properties.get("port"));
        try {
            
            fg = new Socket(properties.get("ip"), port);
            out2fg = new PrintWriter(fg.getOutputStream());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    @Override
    public void finalize() {
        try {

            fg.close();
            out2fg.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
