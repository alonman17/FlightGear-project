package tirgul.mvc;

import tirgul.Controller.Controller;
import tirgul.model.Model;
import tirgul.view.ViewServer;

public class AgentRun {

    public AgentRun() {

        // Run the Agent Server That is listening to connections from the Flight Gear app //

        Model model = new Model();

        // Runing a Demo Backend Server For Testing //

        ViewServer backendServer = new ViewServer(5500);
        new Thread(() -> backendServer.startServer()).start();

        // Connecting to the Backend Server.
        // NOTE: Connection will hapen only if the FlightGear app has started a flight.

        Controller controller = new Controller();
    }
}
