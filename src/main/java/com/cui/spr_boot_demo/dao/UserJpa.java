package com.cui.spr_boot_demo.dao;

import com.cui.spr_boot_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository// 表示这个是一个操作数据库的 Repository 类

public interface UserJpa extends JpaRepository<User, Long> {

    @Modifying// 告诉 JPA 这是 update 或 delete 方法，会对数据库中的数据产生变更
    @Transactional// 声明事务管理
    @Query(value = "delete from user where name = :name", nativeQuery = true)// JPA 会将 :name 用参数 @Param 中的名字替换
    public int deleteByName(@Param("name") String name);// 参数变量
}
