package org.tartea.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class StudyHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyHystrixApplication.class, args);
    }

}
