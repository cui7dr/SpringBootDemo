package com.cui.spr_boot_demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author cui7dr
 * @date 2021/9/23
 */
@Data
@Component
public class YmlData {
    @Value("${name1}")
    private String name1;
    @Value("${lesson1}")
    private String lesson1;
    @Value("${desc1}")
    private String desc1;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getLesson1() {
        return lesson1;
    }

    public void setLesson1(String lesson1) {
        this.lesson1 = lesson1;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }
}
