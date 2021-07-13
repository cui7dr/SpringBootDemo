package com.cui.spr_boot_demo.controller;

import com.cui.spr_boot_demo.dao.UserJpa;
import com.cui.spr_boot_demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cui7dr
 * @date 2021/7/13
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserJpa userJpa;

    @GetMapping("findAll")// 查找所有数据
    public List<User> FindAll() {
        return this.userJpa.findAll();
    }

    @GetMapping("get")// 按主键查找数据
    public User Get(@RequestParam("id") Long id) {
        return this.userJpa.findById(id).get();
    }

}
