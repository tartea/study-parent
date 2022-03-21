package org.tartea.service;

import org.tartea.dto.User;

/**
 * xml方式服务提供者接口
 */
public interface ProviderService {

    String SayHello(String word);

    String SayHello(User user);
}