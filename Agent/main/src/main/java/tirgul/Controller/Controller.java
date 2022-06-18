package tirgul.Controller;

import tirgul.model.AgentServer;

public class Controller {
    AgentController controller;

    public Controller() {

        controller = new AgentController();
        System.out.println("Trying to connect to Backend ...");

        controller.connectToBackendServer("127.0.0.1", 5500);
        new Thread(() -> controller.streamDataFromFG(AgentServer.clientSocket)).start();
        new Thread(() -> controller.getInstructionsFromDB()).start();
    }
}
