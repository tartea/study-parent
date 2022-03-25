package org.tartea.controller;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tartea.entity.User;
import org.tartea.service.ProviderService;

@RestController
public class OrderConsumerController {

    @Reference
    private ProviderService providerService;


    @RequestMapping("getOrder")
    public void getOrder() {
        providerService.sayHello("sayHello");
    }

    @RequestMapping("getOrderUser")
    public void getOrderUser() {
        User user = new User();
        user.setName("jia");
        providerService.sayHello(user);
    }
}
