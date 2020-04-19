package com.wkcto.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //等价于一个Spring applicationContext.xml配置文件
public class BeanConfig {

    /**
     * @Bean 等价于 ：
     *
     * <bean id="restTemplate" class="xxx.xxx.xxx.RestTemplate">
     *
     * </bean>
     *
     * @return
     */
    @LoadBalanced  //使用Ribbon实现负载均衡的调用
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 覆盖掉原来ribbon默认的轮询负载均衡策略
     *
     *
     * @return
     */
    //@Bean
    public IRule iRule() {
        //return new RandomRule(); //采用随机的负载均衡策略
        return new RetryRule(); //采用重试的负载均衡策略
    }
}