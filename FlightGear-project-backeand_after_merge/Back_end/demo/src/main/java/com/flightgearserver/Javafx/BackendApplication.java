package flightgearserver.Javafx;

import main.java.com.flightgearserver.DemoApplication;
import main.java.com.flightgearserver.Javafx.Controllers.onlineController;
import main.java.com.flightgearserver.Javafx.Model.onlineModel;
import main.java.com.flightgearserver.Javafx.View.onlineWindowController;
import com.flightgearserver.agent.AgentManager;
import com.flightgearserver.agent.AgentServer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.nio.file.Path;

public class BackendApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(DemoApplication.class)
                .run(args);
        AgentServer agentServer=new AgentServer();
        agentServer.start(5500);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Path.of("src/main/java/com/flightgearserver/Javafx/resources/Controller.fxml").toUri().toURL());
        Parent root = (Parent) fxmlLoader.load();
        onlineWindowController wc=fxmlLoader.getController();
        onlineModel m=new onlineModel();
        onlineController controller=new onlineController(wc,m);
        AgentManager.getInstance().addPropertyChangeListener(m);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() {
        //this.applicationContext.close();
        Platform.exit();
    }
}


