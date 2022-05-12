package com.flightgearserver.demo;

import com.google.cloud.storage.Storage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;
import java.security.GeneralSecurityException;


@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        SpringApplication.run(DemoApplication.class, args);
    }

}
