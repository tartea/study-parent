package org.tartea.study.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tartea.FeignConfig;

@FeignClient(value = "study-rest",configuration = FeignConfig.class)
public interface IRestServer {


    @RequestMapping("/restServer")
    String feignRestServer();

}
