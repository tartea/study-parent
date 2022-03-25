package org.tartea.service;


import org.tartea.entity.User;

/**
 * xml方式服务提供者接口
 */
public interface ProviderService {

    String sayHello(String word);

    String sayHello(User user);
}