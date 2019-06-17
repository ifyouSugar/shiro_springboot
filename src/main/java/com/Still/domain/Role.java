package com.Still.domain;

import lombok.Data;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 21:37
 **/
@Data
public class Role {
    private Long id;
    private String roleName;
    private User user;
    private List<Permission> permissions;
}
