package org.tartea;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.tartea.dto.User;
import org.tartea.service.ProviderService;

@SpringBootTest
public class ApiTest {

    @Reference
    private ProviderService providerService;

    @Test
    public void testSayHello(){
        String result = providerService.sayHello("tartea");
        System.out.println(result);
    }
    @Test
    public void testSayUser(){
        User user = new User();
        user.setName("tartea");
        String result = providerService.sayHello(user);
        System.out.println(result);
    }
}
