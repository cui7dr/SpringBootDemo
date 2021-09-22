package com.cui.spr_boot_demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cui7dr
 * @date 2021/9/22
 */
@Service
public class Scheduling1Service {

    //每 2 秒执行一次（若上次任务执行时间超过 2 秒，则立即执行，否则上一个任务开始时算起 2 秒后执行本次任务
    @Scheduled(fixedRate = 2000)
    public void test1() throws InterruptedException {
        Thread.sleep(1000L);//模拟定时任务执行耗费 1s
        Thread.sleep(3000L);//模拟定时任务执行耗费 3s
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date) + "==>SchedulingService.test1 is called");
    }

    //上一个任务执行 2 秒后再执行本次任务
    @Scheduled(fixedDelay = 2000)
    public void test2() throws InterruptedException {
        Thread.sleep(3000L);//模拟定时任务执行耗费 3s
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date) + "==>SchedulingService.test2 is called");
    }

    //支持 corn 表达式
    @Scheduled(cron = "0 0 1 * * ?")//corn表达式可以参考 http://corn.qqe2.com
    public void test3() throws InterruptedException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date) + "==>SchedulingService.test3 is called");
    }


}
