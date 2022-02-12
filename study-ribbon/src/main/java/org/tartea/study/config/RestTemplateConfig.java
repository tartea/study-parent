package org.tartea.study.config;

/**
 * @Author: jiawenhao
 * @Date: 2020/12/19 16:03
 * @Description:
 * @see
 * @since 2.0
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
//@RibbonClient(name = "study-rest",configuration = RibbonRuleConfig.class)
public class RestTemplateConfig {

    /**
     * LoadBalanced 让使用该注解得方法拥有负载均衡的能力，所有使用LoadBalanced注解的方法都会
     * 被拦截器LoadBalancerInterceptor拦截，然后根据调用的服务名称在LoadBalancerClient中调用服务
     *
     * @return
     * @date 2020/12/22
     */
    @Bean("restTemplate")
    @LoadBalanced
    public RestTemplate restTemplate(@Qualifier("simpleClientHttpRequestFactory") ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);//在Spring容器中注入RestTemplate对象
    }

    @Bean("ipTemplate")
    public RestTemplate ipTemplate(@Qualifier("simpleClientHttpRequestFactory") ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);//在Spring容器中注入RestTemplate对象
    }


    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        //初始化RestTemplate对象需要的Factory工厂类，biang注入到Spring容器中
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(50000);//读取反馈超时时间5000ms
        factory.setConnectTimeout(15000);//连接超时时间15000ms
        return factory;
    }
}