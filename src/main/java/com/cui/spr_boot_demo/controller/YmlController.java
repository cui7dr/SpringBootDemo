package com.cui.spr_boot_demo.controller;

import com.cui.spr_boot_demo.entity.YmlData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cui7dr
 * @date 2021/9/23
 */
@RestController
@RequestMapping("yml")
public class YmlController {

    @Resource
    private YmlData ymlData;

    @GetMapping("test")
    public void test() throws JsonProcessingException {
        System.out.println(ymlData.getDesc1());
    }
}
