package com.cui.spr_boot_demo;

import com.cui.spr_boot_demo.dao.UserJpa;
import com.cui.spr_boot_demo.entity.User;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//Web 模拟，使用随机端口启动
@RunWith(SpringRunner.class)//使用 SpringRunner 加载上下文
class SprBootDemoApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;//测试类

    @Resource
    private UserJpa userJpa;

    @Test
    void contextLoads() {
    }

    @Test //这是一个 test 单元测试文件
    public void test1() {
        int num = new Integer(1);
        Assert.assertEquals(num, 1);//可以简单的理解为 if 条件 = if(num == 1) syso("ok")
    }

    @Test
    public void test2() {
        List<String> list1 = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("a", "b");
        List<String> list3 = list2;

        Assert.assertEquals(list1, list2);//通过
        Assert.assertEquals(list3, list2);//通过
        Assert.assertSame(list3, list2);//通过
        Assert.assertSame(list1, list2);//不通过，因为 list1 和 list2 分别指向不同的内存地址
    }

    @Test
    public void test3() throws URISyntaxException {
        String result = testRestTemplate.getForObject("/demo/test1", String.class);
        Assert.assertEquals(result, "hello junit test");
    }

    @Test
    @Transactional
    public void test4() {
        User user = new User();
        user.setName("junit");
        user.setAge(20);
        user.setDptId(3l);
        userJpa.save(user);
        Assert.assertTrue(user.getId() != null);
        Assert.assertNotNull(user.getId());

    }

}
