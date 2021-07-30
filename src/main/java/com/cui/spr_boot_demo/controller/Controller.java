package com.cui.spr_boot_demo.controller;

import com.cui.spr_boot_demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//@RequestMapping("demo")//类注解，指该 Java 类所在的 rest 请求都必须以这个里面设定的值开头，该类中所有的请求路径都必须以 demo 开头
//@RestController//作为注解，告诉 SpringBoot 这个类是一个 rest 请求的类
public class Controller {

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
    //第一日内容：定义 get/post 方法
//    @GetMapping("method1")//这是一个 get 请求，请求路径是 demo/method1，没有入参，返回字符串 hello springboot
//    public String method1() {
//        return "hello springBoot";
//    }
//
//    @GetMapping("method2")//get 请求，接收参数 a
//    public String method2(@RequestParam("a") String a) {
//        return "hello springBoot" + a;
//    }
//
//    @GetMapping("method3")//get 请求，接收两个 integer 的参数，并将两个数值相加后返回
//    public String method3(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
//        return "hello springBoot:" + (a + b);
//    }
//
//    @GetMapping("method4")//get 请求，接收路径参数并返回
//    public String method4(@PathVariable("c") String c) {
//        return "hello springBoot:" + c;
//    }
//
//    @GetMapping("method5/{c}")//接收路径参数并返回
//    public String method5(@PathVariable("c") String c) {
//        return "hello springBoot:" + c;
//    }
//
//    @GetMapping("method6")//post 请求，接收 map 参数，无返回值
//    public void method6(@RequestBody Map map) {
//        for (Object obj : map.keySet()) {
//            System.out.println(obj + "--->" + map.get(obj));
//        }
//    }

    /**
     * 使用 @Value 注解变量，并通过 ${} 标注该变量对应在 .yaml 文件中的名字
     */
    //第二日内容：获取 .yaml 文件中的参数
    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${birthday}")
    private Date birthday;

    @Resource
    private User user;

    @Value("${animals2}")
    private List<String> animals2;

    @GetMapping("method")
    public void method() {
        System.out.println("name=>" + name);
        System.out.println("age=>" + age);
        System.out.println("birthday=>" + birthday);

        //使用该方法接收 yaml 里面的变量，需在 main 函数上增加注解 @EnableConfigurationProperties
        System.out.println(user.getName());
        System.out.println(user.getAge());
        //System.out.println(user.getBirthday());
        //list2
        System.out.println("遍历 animals2: ");
        for (Object item : animals2) {
            System.out.println(item);
        }
        //list1
//        System.out.println("遍历 user 对象中的 animals1: ");
//        for (Object animal : this.user.getAnimals1()) {
//            System.out.println(animal);
//        }
        //map1
//        System.out.println("遍历 user 对象中的 fruit1: ");
//        for (Object item : this.user.getFruit1().keySet()) {
//            System.out.println(item + "->" + this.user.getFruit1().get(item));
//        }
        //map2
//        System.out.println("遍历 user 对象中的 fruit2: ");
//        for (Object item : this.user.getFruit2().keySet()) {
//            System.out.println(item + "->" + this.user.getFruit2().get(item));
//        }
    }

}
