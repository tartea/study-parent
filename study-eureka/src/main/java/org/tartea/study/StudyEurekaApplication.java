package org.tartea.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//服务的发现者
@EnableEurekaServer
public class StudyEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyEurekaApplication.class, args);
    }

}
