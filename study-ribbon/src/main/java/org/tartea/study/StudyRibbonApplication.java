package org.tartea.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudyRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyRibbonApplication.class, args);
    }

}
