package com.cui.spr_boot_demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("demo")//类注解，指该 Java 类所在的 rest 请求都必须以这个里面设定的值开头，该类中所有的请求路径都必须以 demo 开头
@RestController//作为注解，告诉 SpringBoot 这个类是一个 rest 请求的类
public class Controller {

    @GetMapping("method1")//这是一个 get 请求，请求路径是 demo/method1，没有入参，返回字符串 hello springboot
    public String method1() {
        return "hello springBoot";
    }

    @GetMapping("method2")//get 请求，接收参数 a
    public String method2(@RequestParam("a") String a) {
        return "hello springBoot" + a;
    }

    @GetMapping("method3")//get 请求，接收两个 integer 的参数，并将两个数值相加后返回
    public String method3(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return "hello springBoot:" + (a + b);
    }

    @GetMapping("method3")//get 请求，接收路径参数并返回
    public String method3(@PathVariable("c") String c) {
        return "hello springBoot:" + c;
    }

    @GetMapping("method4/{c}")//接收路径参数并返回
    public String method4(@PathVariable("c") String c) {
        return "hello springBoot:" + c;
    }

    @GetMapping("method4")//post 请求，接收 map 参数，无返回值
    public void method4(@RequestBody Map map) {
        for (Object obj : map.keySet()) {
            System.out.println(obj + "--->" + map.get(obj));
        }
    }

    /**
     * 1.get 请求携带参数，通过 ? 后面接参数，多个参数用 & 符号拼接；
     * 2.post 请求通过 body 请求体携带参数，发送 json 数据包，后台用 map 接收
     *
     * @RestController 注解在类上，告知 Spring Boot 这是一个 rest 请求类
     * @RequestMapping 注解在类上，所有请求该类的路径都必须带该路径参数
     * @GetMapping 注解在方法上，标注是一个 get 请求，且标注路径
     * @PostMapping 注解在方法上，标注是一个 post 请求，且标注路径
     * @RequestParam 注解在参数上，请求路径使用 ? 带参数，使用 & 符号带多个参数
     * @RequestBody 注解在参数上，post 请求可用，使用 http 的请求体携带参数
     */

}
