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
            backeEndSocket = new Socket(ip, port);
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

    public void getInstructionsFromDB() {

        StringBuilder sb = new StringBuilder();
        try {
            Scanner inFromDB = new Scanner(new InputStreamReader(backeEndSocket.getInputStream()));

            while (inFromDB.hasNext()) {
                sb.append(inFromDB.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
