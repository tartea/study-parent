package org.tartea.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.apache.dubbo.config.annotation.Service;
import org.tartea.dto.User;
import org.tartea.service.ProviderService;


/**
 * xml方式服务提供者实现类
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Value("${dubbo.protocol.port}")
    private String dubboPort;

    // 1.dubbo服务发布的时候采用dubbo 注解方式,使用 dubbo @Service注解 进行发布服务
    // 2.dubbo 提供的 @Service 将该接口的实现注册到注册中心上去
    // 3.spring 的 @Service 将该类注入到spring容器中
    @Override
    public String sayHello(String word) {
        System.out.println("订单服务调用会员服务...dubbo服务端口号：" + dubboPort);
        return "订单服务调用会员服务...dubbo服务端口号：" + dubboPort;
    }

    @Override
    public String sayHello(User user) {
        System.out.println("订单服务调用会员服务...dubbo服务端口号：" + dubboPort + user.toString());
        return "订单服务调用会员服务...dubbo服务端口号：" + dubboPort;
    }
}