package tirgul.mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tirgul.Controller.AgentController;
import tirgul.model.AgentServer;
import tirgul.model.FgClientHandler;
import tirgul.model.Model;
import tirgul.view.Cli;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxl = new FXMLLoader();
        BorderPane root = fxl.load(getClass().getResource("primary.fxml").openStream());
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        PrimaryController pc = new PrimaryController();
        Model model = new Model();
        AgentController controller = new AgentController();

        controller.connectToDB("127.0.0.1", 5500);
        new Thread(() -> controller.streamDataFromFG(FgClientHandler.theClient)).start();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml +
                ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}