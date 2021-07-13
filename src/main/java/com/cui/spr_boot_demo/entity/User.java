package com.cui.spr_boot_demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 建立一个 dto 对象，接收 yaml 里面的数据，其中 private 变量的名字需与 yaml里面的名字一样，
 */

@Entity //标识这是一个与数据库表对应的 entity 类
@Data //lombok 的一个注解
@Table(name = "user") // 这个类是与数据库哪个表对应
//@Component//标志该文件是一个组件类，这样才能让 Spring Boot 扫描到
//@ConfigurationProperties(prefix = "user")//标志该对象是映射 yaml 文件中以哪个开头的变量
public class User implements Serializable {

    private static final long serialVersionUID = 829933141479418804L;

    /**
     * 主键 ID
     */
    @Id //这个字段是数据库表的主键
    @Column(name = "id") //这个属性对应表的哪个字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键采用数据库自增方式
    private Long id;

    /**
     * 部门 ID
     */
    @Column(name = "dpt_id")
    private Long dptId;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 头像
     */
    @Column(name = "head_img")
    private String headImg;


    // dto 对象使用
//    private Date birthday;
//    //map1
//    private Map fruit1;
//    //map2
//    private Map fruit2;
//    //list1
//    private List animals1;
//
//    public List getAnimals1() {
//        return animals1;
//    }
//
//    public void setAnimals1(List animals1) {
//        this.animals1 = animals1;
//    }
//
//    public Map getFruit1() {
//        return fruit1;
//    }
//
//    public void setFruit1(Map fruit1) {
//        this.fruit1 = fruit1;
//    }
//
//    public Map getFruit2() {
//        return fruit2;
//    }
//
//    public void setFruit2(Map fruit2) {
//        this.fruit2 = fruit2;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
}
