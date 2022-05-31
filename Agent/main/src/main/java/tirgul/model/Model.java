package tirgul.model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Model extends Observable {

    
   public AgentServer agentServer;
   public Client client; 

    public Model() {
        agentServer = new AgentServer();
        new Thread(() -> agentServer.startServer(5400)).start();
        while(!agentServer.isConnected());
        client = new Client(5402, "127.0.0.1");
    }

}
