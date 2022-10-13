package com.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author feng.dai
 * @Date 2022/10/13 14:32
 * @Project_Name get_parent_master
 * @Package_Name com.df
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class GetWebApp {
    public static void main(String[] args) {
        SpringApplication.run(GetWebApp.class);
    }
}
