package com.cui.spr_boot_demo.entity;

import lombok.Data;

/**
 * @author cui7dr
 * @date 2021/9/28
 */
@Data
public class ResultDto {
    //请求结果 0 表示失败，其他成功
    private int code;
    //失败的消息
    private String msg;
    //实际返回到前端的数据
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
