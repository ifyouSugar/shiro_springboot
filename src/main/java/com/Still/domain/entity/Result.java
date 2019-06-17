package com.Still.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 23:31
 **/
@Data
public class Result implements Serializable {

    //是否成功
    private boolean success;
    //操作返回消息
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
