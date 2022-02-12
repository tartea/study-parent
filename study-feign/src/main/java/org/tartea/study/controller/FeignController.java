package org.tartea.study.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tartea.study.feign.IRestServer;

@RestController
public class FeignController {


    @Autowired
    private IRestServer restServer;


    @RequestMapping("restFeign")
    public String restFeign(){
        return restServer.feignRestServer();
    }
}
