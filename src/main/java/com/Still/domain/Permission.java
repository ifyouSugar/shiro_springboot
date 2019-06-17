package com.Still.domain;

import lombok.Data;
import org.apache.ibatis.mapping.FetchType;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 21:38
 **/
@Data
public class Permission {

    private Long id;
    private String permission;
    private Role role;
}
