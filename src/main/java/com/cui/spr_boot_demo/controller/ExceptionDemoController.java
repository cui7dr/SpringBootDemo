package com.cui.spr_boot_demo.controller;

import com.cui.spr_boot_demo.dao.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cui7dr
 * @date 2021/9/28
 */
@RestController
public class ExceptionDemoController {
    @GetMapping("testEx")
    public String test() throws Exception {
        if (true) {
            throw new Exception("error");
        }
        return "ok";
    }

    @GetMapping("testEx1")
    public String test1() throws Exception {
        if (true) {
            throw new NullPointerException("NullPointerException");
        }
        return "ok";
    }

    @GetMapping("testEx2")
    public String test2() throws Exception {
        if (true) {
            throw new RuntimeException("RuntimeException");
        }
        return "ok";
    }

    @GetMapping("testEx3")
    public String test3() throws MyException {//实际执行的是 GlobalExceptionHandler 中的异常
        if (true) {
            throw new RuntimeException("RuntimeException");
        }
        return "ok";
    }
}
