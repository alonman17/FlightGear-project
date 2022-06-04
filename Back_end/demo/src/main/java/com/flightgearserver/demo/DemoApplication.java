package com.flightgearserver.demo;

import com.flightgearserver.demo.Javafx.BackendApplication;
import com.flightgearserver.demo.agent.AgentServer;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);

        Application.launch(BackendApplication.class,args);

    }

}
