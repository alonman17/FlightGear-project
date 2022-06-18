package tirgul.Controller;

import java.net.Socket;

import tirgul.model.Client;
import tirgul.model.FgClientHandler;

public class Pilot implements Ipilot {

    public Client pilot;
    public Socket backendSocket;
    public FgClientHandler fgClient;

    public Pilot() {
        pilot = new Client();
    }

    @Override
    public void handleInstractions() {
        // TODO: Instractions given from DB shuld be scaned and maped to the right
        // command
    }

    @Override
    public void sendCommands(String command) {
        // send the command to flight gear
    }

    @Override
    public void getCommands(String command) {
        // TODO: get command from the DB to send forword to FG
    }

}
