package tirgul.Controller;

import tirgul.model.AgentServer;

public class Controller {
    AgentController controller;

    public Controller() {
        
        controller = new AgentController();

        controller.connectToDB("127.0.0.1", 5500);
        System.out.println("Connected to DB");
        new Thread(() -> controller.streamDataFromFG(AgentServer.client)).start();
    }
}
