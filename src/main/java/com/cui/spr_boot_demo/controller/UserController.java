package com.cui.spr_boot_demo.controller;

import com.cui.spr_boot_demo.dao.UserJpa;
import com.cui.spr_boot_demo.entity.User;
import com.cui.spr_boot_demo.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private UserService userService;

    @GetMapping("findAll")// 查找所有数据
    public List<User> findAll() {
        return this.userJpa.findAll();
    }

    @GetMapping("get")// 按主键查找数据
    public User get(@RequestParam("id") Long id) {
        return this.userJpa.findById(id).get();
    }

    @GetMapping("save")//保存数据
    public void save(@RequestBody User user) {// 使用 @RequestBody 接收数据
        userJpa.save(user);
    }

    @GetMapping("delete")// 删除数据
    public void delete(@RequestParam("id") Long id) {
        userJpa.deleteById(id);
    }

    //新增方法
    @GetMapping("deleteByName")// 根据名称删除
    public void deleteByName(@RequestParam("name") String name) {
        this.userJpa.deleteByName(name);
    }

    @GetMapping("update")// 更新数据
    public void update(@RequestParam("id")Long id,@RequestParam("name")String name){
        User user=this.userJpa.findById(id).get();// 先根据 id 将数据 load 出来
        user.setName(name);// 更新数据
        this.userJpa.save(user);
    }

    //自定义查询
    @GetMapping("findByAge")// 根据年龄查找数据
    public List<User> findByAge(@RequestParam("age")Integer age){
        return this.userJpa.findByAge(age);
    }

    /**
     * Transaction 事务
     */
    @Transactional// 声明式事务管理中使用的注解
    @GetMapping("save1")
    public String save1(){
        User user=new User();
        user.setDptId(1L);
        user.setName("Save1Test");
        user.setAge(22);
        user.setEmail("save1@a.com");
        user.setHeadImg("a");
        this.userJpa.save(user);
        //模拟发生了异常
        System.out.println(1/0);//在不使用 @Transactional 时，后台报错，数据依然被保存，使用后数据不保存
        return "ok";
    }


    @GetMapping("save2")
    public String save2() throws Exception{
        //模拟业务操作
        this.userService.saveBiz();
        return "ok";
    }
}
