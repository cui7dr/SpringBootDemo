package com.cui.spr_boot_demo.service;

import com.cui.spr_boot_demo.dao.UserJpa;
import com.cui.spr_boot_demo.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author cui7dr
 * @date 2021/7/18
 */
@Service
public class LogService {

    @Resource
    private UserJpa userJpa;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    //同一业务里面，即使声明为“Propagation.REQUIRES_NEW”也不会新启一个事务，必须调用另一个类的“Propagation.REQUIRES_NEW”方法才行，所以使用 UserService 里面调用该方法
    public void saveLog(){
        User user=new User();
        user.setDptId(1L);
        user.setName("log");
        user.setAge(12);
        user.setEmail("log@log.com");
        user.setHeadImg("log");
        this.userJpa.save(user);
        System.out.println("log");
    }
}
