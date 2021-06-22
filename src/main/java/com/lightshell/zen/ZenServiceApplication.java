package com.lightshell.zen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ZenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZenServiceApplication.class, args);
    }

}
