package com.cui.spr_boot_demo.controller;

import com.cui.spr_boot_demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

/**
 * @author cui7dr
 * @date 2021/7/30
 */
@RequestMapping("demo")//类注解，指该 Java 类所在的 rest 请求都必须以这个里面设定的值开头，该类中所有的请求路径都必须以 demo 开头
@RestController//作为注解，告诉 SpringBoot 这个类是一个 rest 请求的类
public class DemoController {

    @Resource
    private RestTemplate restTemplate;//将 RestTemplate 注入进来

    @GetMapping("getUser")
    public void getUser(@RequestParam("name") String name) throws Exception {
        //此处将调用第三方服务获取 User 对象
        User forObject = restTemplate.getForObject(new URI("http://localhost:8081/api/get?username=" + name), User.class);
        System.out.println(new ObjectMapper().writeValueAsString(forObject));
    }

    @GetMapping("saveUser")
    public void saveUser() {
        User user = new User();
        user.setName("restTemplate");
        user.setAge(32);
        user.setDptId(2l);
        //此处需要远程调用第三方服务，将 User 对象发送给第三方
        String result = restTemplate.postForObject("http://localhost:8081/api/save", user, String.class);
        //post 请求有点问题，暂时没找到解决办法，可能跟服务器不允许静态文件响应 post 请求有关
        System.out.println(result);
    }

}
