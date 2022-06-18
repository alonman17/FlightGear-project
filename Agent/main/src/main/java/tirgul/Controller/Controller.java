package tirgul.Controller;

import tirgul.model.AgentServer;

public class Controller {
    AgentController controller;

    public Controller() {

        controller = new AgentController();
        System.out.println("Trying to connect to Backend ...");
        controller.connectToBackendServer("127.0.0.1", 5500);
        System.out.println("Connected to Backend Server");
        new Thread(() -> controller.streamDataFromFG(AgentServer.clientSocket)).start();
    }
}
