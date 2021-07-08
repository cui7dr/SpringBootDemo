package com.cui.spr_boot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties
@SpringBootApplication
public class SprBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprBootDemoApplication.class, args);
    }

    @GetMapping("helloworld")
    public String helloworld(){
        return "hello world";
    }

}
