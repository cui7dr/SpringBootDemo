package com.cui.spr_boot_demo.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 建立一个 dto 对象，接收 yaml 里面的数据，其中 private 变量的名字需与 yaml里面的名字一样，
 */

@Component//标志该文件是一个组件类，这样才能让 Spring Boot 扫描到
@ConfigurationProperties(prefix = "user")//标志该对象是映射 yaml 文件中以哪个开头的变量
public class User {

    private String name;
    private Integer age;
    private Date birthday;
    //map1
    private Map fruit1;
    //map2
    private Map fruit2;
    //list1
    private List animals1;

    public List getAnimals1() {
        return animals1;
    }

    public void setAnimals1(List animals1) {
        this.animals1 = animals1;
    }

    public Map getFruit1() {
        return fruit1;
    }

    public void setFruit1(Map fruit1) {
        this.fruit1 = fruit1;
    }

    public Map getFruit2() {
        return fruit2;
    }

    public void setFruit2(Map fruit2) {
        this.fruit2 = fruit2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
