package com.cui.spr_boot_demo.dao;

import com.cui.spr_boot_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository// 表示这个是一个操作数据库的 Repository 类
public interface UserJpa extends JpaRepository<User,Long> {

}
