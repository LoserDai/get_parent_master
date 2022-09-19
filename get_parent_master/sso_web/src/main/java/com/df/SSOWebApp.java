package com.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author feng.dai
 * @package com.df
 * @project get_parent_master
 * @Date 2022/9/19 10:33
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SSOWebApp {
    public static void main(String[] args) {
        SpringApplication.run(SSOWebApp.class);
    }
}
