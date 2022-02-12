package org.tartea.study.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {


    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("ipTemplate")
    private RestTemplate ipTemplate;


    /**
     * 通过ip和端口访问服务
     * @return
     */
    @RequestMapping("restByIp")
    public String restByIp(){
        return "this is IP Access   " + ipTemplate.getForObject("http://localhost:8888/restServer", String.class);
    }


    /**
     * 通过负载名称访问服务
     * @return
     */
    @RequestMapping("restByLoadBalancing")
    public String restByLoadBalancing(){
        return "this is load balancing   " + restTemplate.getForObject("http://study-rest/restServer", String.class);
    }
}
