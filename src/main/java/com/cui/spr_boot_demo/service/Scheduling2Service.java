package com.cui.spr_boot_demo.service;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

/**
 * @author cui7dr
 * @date 2021/9/22
 */
@Service
public class Scheduling2Service implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("ccccccc");
            }
        }, triggerContext -> {
            return new CronTrigger("0/1 * * * * ?").nextExecutionTime(triggerContext);
        });
    }
}
