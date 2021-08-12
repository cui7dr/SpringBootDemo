package com.cui.spr_boot_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cui7dr
 * @date 2021/8/12
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("test1")
    public String test1(){
        System.out.println("rest.test1 is called");
        return "test1";
    }

    @GetMapping("test2")
    public String test2(){
        System.out.println("rest.test2 is called");
        return "test2";
    }

    @GetMapping("test3")
    public String test3(@RequestParam("a")String a){
        System.out.println("rest.test3 is called");
        return "test3";
    }

    /**
     * 1.demo/test1 和 demo/test3 测试会被拦截进拦截器
     * 2.demo/test2 不会进拦截器
     * 3.demo/test3?a=1 会进拦截器，但是进不来 controller
     */

}
