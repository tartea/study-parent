package org.tartea.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServerController {


    @RequestMapping("restServer")
    public String rest(){
        return "this is a rest server2";
    }
}
