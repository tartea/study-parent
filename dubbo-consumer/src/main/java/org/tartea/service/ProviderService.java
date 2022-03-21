package org.tartea.service;

import org.tartea.dto.User;

public interface ProviderService {

    String sayHello(String name);

    String sayHello(User user);
}