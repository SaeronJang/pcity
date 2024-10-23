package com.pcity.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PcityApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcityApplication.class, args);
    }

}
