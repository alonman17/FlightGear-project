package com.flightgearserver.demo.Javafx;

import com.flightgearserver.demo.DemoApplication;
import com.flightgearserver.demo.Javafx.Controllers.Controller;
import com.flightgearserver.demo.agent.AgentServer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.URL;
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
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        FXMLLoader fxmlLoader = new FXMLLoader(Path.of("src/main/java/com/flightgearserver/demo/Javafx/resources/Controller.fxml").toUri().toURL());
        Parent root = fxWeaver.loadView(Controller.class);
        Scene scene = new Scene(fxmlLoader.load(),400,600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        //this.applicationContext.close();
        Platform.exit();
    }
}


