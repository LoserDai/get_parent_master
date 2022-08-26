package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author feng.dai
 * @Date 2022/8/26 15:03
 * @Version 1.0
 */
@RestController
@EnableAutoConfiguration
public class SpringBootApplication {

    @RequestMapping("/")
    String home(){
        return "Hello SpringBoot~";
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class,args);
    }
}
