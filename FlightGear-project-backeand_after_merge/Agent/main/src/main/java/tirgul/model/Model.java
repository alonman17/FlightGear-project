package tirgul.model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Model extends Observable {

    
   public AgentServer agentServer;
   public Client client; 

    public Model() {
        agentServer = new AgentServer();
        new Thread(() -> agentServer.startServer(5400)).start();
    }

}
