package cn.wengzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wengzi
 * @date 2019/10/26 night 23:54
 * @Description 服务提供者, 需要注册到注册中心
 * @EnableEurekaClient 开启服务消费
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication2.class, args);
    }
}
