package org.tartea.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudyFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyFeignApplication.class, args);
    }

}
