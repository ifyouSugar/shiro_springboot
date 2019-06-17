package com.Still.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 21:37
 **/
@Data
public class User {

    private Integer id;
    private String name;
    private String password;
    private List<Role> roles;
}
