package com.devmind.wsii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class WsiiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsiiApplication.class, args);
    }

}
