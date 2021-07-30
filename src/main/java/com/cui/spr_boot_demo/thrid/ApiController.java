package com.cui.spr_boot_demo.thrid;

import com.cui.spr_boot_demo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

/**
 * @author cui7dr
 * @date 2021/7/30
 */
@RestController
@RequestMapping("api")
//模拟第三方提供服务
public class ApiController {

    //模拟获取数据
    @GetMapping("get")
    public User get(@RequestParam("username") String username) {
        System.out.println("从数据库中查询 username [" + username + "] 的数据");
        User user = new User();
        user.setName("springboot");
        user.setAge(21);
        user.setDptId(3l);
        return user;
    }

    //模拟接收数据保存到数据库
    @GetMapping("save")
    public User save(@RequestBody User user) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(user));
        //TODO:保存到数据库
        return user;
    }
}
