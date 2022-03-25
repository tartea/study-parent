package org.tartea.service;

import org.tartea.entity.User;

public interface ProviderService {

    String sayHello(String word);

    String sayHello(User user);
}