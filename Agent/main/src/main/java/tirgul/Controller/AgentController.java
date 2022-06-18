package tirgul.Controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import tirgul.model.FgClientHandler;

public class AgentController {

    Pilot pilot;
    FgClientHandler fgClient;
    DataHandler dataHandler;
    Socket backeEndSocket;

    public AgentController() {
        pilot = new Pilot();
        fgClient = new FgClientHandler();
        dataHandler = new DataHandler();
    }

    public void connectToBackendServer(String ip, int port) {

        try {
            this.backeEndSocket = new Socket(ip, port);
            System.out.println("Connected to Backend");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void streamDataFromFG(Socket fgDataSocket) {

        try {

            PrintWriter out2back = new PrintWriter(new OutputStreamWriter(backeEndSocket.getOutputStream()));
            Scanner inFromFg = new Scanner(new InputStreamReader(fgDataSocket.getInputStream()));

            while (inFromFg.hasNext()) {
                out2back.println(dataHandler.ParsData(inFromFg.nextLine()));
            }
            out2back.close();
            inFromFg.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getInstructionsFromBackend() {

        StringBuilder sb = new StringBuilder();
        try {
            Scanner inFromBackend = new Scanner(new InputStreamReader(backeEndSocket.getInputStream()));
            while (inFromBackend.hasNext()) {
                sb.append(inFromBackend.nextLine());
                pilot.sendCommands(sb.toString());
                sb.setLength(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        pilot.sendCommands(sb.toString());
    }

    public void sendAnanalitics() {

        dataHandler.PreformAnalitics();

        try {
            PrintWriter out2back = new PrintWriter(new OutputStreamWriter(backeEndSocket.getOutputStream()));
            Scanner inFromFg = new Scanner(new FileReader("analitics_file.txt"));
            while (inFromFg.hasNext()) {
                out2back.println(inFromFg.nextLine());
            }
            out2back.close();
            inFromFg.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
