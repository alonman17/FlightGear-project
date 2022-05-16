package com.flightgearserver.demo;

import com.flightgearserver.demo.agent.AgentServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import java.io.IOException;

import java.security.GeneralSecurityException;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        SpringApplication.run(DemoApplication.class, args);
        AgentServer server=new AgentServer();
        server.start(5402);
    }

}
