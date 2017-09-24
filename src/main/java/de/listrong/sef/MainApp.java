package de.listrong.sef;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
        log.debug("Start {} success", MainApp.class.getSimpleName());
    }

}
