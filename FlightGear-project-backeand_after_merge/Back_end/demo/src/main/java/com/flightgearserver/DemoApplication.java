package flightgearserver;

import flightgearserver.Javafx.BackendApplication;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoApplication {
    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);

        Application.launch(BackendApplication.class,args);

    }

}
