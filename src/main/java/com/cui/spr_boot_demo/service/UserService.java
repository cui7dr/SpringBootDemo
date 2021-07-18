package com.cui.spr_boot_demo.service;

import com.cui.spr_boot_demo.dao.UserJpa;
import com.cui.spr_boot_demo.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author cui7dr
 * @date 2021/7/18
 */
@Service
public class UserService {

    @Resource
    private UserJpa userJpa;
    @Resource
    private LogService logService;

    @Transactional(rollbackFor = Exception.class)
    public void saveBiz()throws Exception{
        System.out.println("save2");
        User user=new User();
        user.setDptId(1L);
        user.setName("biz");
        user.setAge(14);
        user.setEmail("biz@biz.com");
        user.setHeadImg("biz");
        this.userJpa.save(user);
        //模拟保存日志
        this.logService.saveLog();
        //模拟发生异常
        throw new Exception("test1");
    }
}
