package com.cui.spr_boot_demo.dao;

/**
 * @author cui7dr
 * @date 2021/9/29
 */
public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable casue) {
        super(message, casue);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
