package com.wkcto.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启仪表盘功能
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}