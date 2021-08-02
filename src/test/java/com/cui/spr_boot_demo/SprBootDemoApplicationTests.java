package com.cui.spr_boot_demo;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)//使用 SpringRunner 加载上下文
class SprBootDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test //这是一个 test 单元测试文件
    public void test1(){
        int num=new Integer(1);
        Assert.assertEquals(num,1);//可以简单的理解为 if 条件 = if(num == 1) syso("ok")
    }

}
