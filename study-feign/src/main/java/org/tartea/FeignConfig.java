package org.tartea;

import feign.Retryer;
import org.springframework.context.annotation.Bean;


public class FeignConfig {

    /**
     * 设置重试
     *
     * @return
     */
    @Bean
    public Retryer feignRetryer() {
        Retryer retryer = new Retryer.Default(1000, 10000, 10);
        return retryer;
    }
}
