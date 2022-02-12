package org.tartea.study.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonRuleConfig {

    /**
     * 1、随机分配流量
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

    /**
     * 2、访问请求最少的地址
     */
//    @Bean
//    public IRule ribbonRule() {
//        return new BestAvailableRule();
//    }
    /**
     * 3、轮询的策略
     */
//    @Bean
//    public IRule ribbonRule() {
//        return new RoundRobinRule();
//    }

}
