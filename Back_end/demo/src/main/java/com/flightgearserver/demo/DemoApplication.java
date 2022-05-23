package com.flightgearserver.demo;

import com.flightgearserver.demo.ServerScoket.GenericServer;
import com.flightgearserver.demo.agent.AgentServer;
import com.flightgearserver.demo.agent.SimpleHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        GenericServer server=new GenericServer();
        //server.start(5400,new SimpleHandler());
        AgentServer agentServer=new AgentServer();
        agentServer.start(5500);
    }

}
