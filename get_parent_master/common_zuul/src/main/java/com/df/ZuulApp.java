package com.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @Author feng.dai
 * @package com.df
 * @project get_parent_master
 * @Date 2022/9/20 16:40
 */
@SpringBootApplication
@EnableZuulServer
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class);
    }
}
