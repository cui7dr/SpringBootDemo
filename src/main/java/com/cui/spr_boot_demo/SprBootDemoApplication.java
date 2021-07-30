package com.cui.spr_boot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableConfigurationProperties
@SpringBootApplication
public class SprBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprBootDemoApplication.class, args);
    }

    @GetMapping("helloworld")
    public String helloworld() {
        return "hello world";
    }

    @Bean
    public SimpleClientHttpRequestFactory httpClientFactory() {
        SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(1000 * 5);
        httpRequestFactory.setConnectTimeout(1000 * 5);
        return httpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate(SimpleClientHttpRequestFactory httpClientFactory) {
        RestTemplate restTemplate = new RestTemplate(httpClientFactory);
        return new RestTemplate();
    }


}
