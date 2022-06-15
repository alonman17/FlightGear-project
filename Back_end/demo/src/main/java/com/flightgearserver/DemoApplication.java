package com.flightgearserver;

import com.flightgearserver.Javafx.BackendApplication;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableCaching
@Configuration
@EnableSpringConfigured
public class DemoApplication {
    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);

        Application.launch(BackendApplication.class,args);

    }

}
