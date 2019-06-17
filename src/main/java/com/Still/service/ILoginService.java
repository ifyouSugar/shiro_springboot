package com.Still.service;

import com.Still.domain.User;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 21:43
 **/
public interface ILoginService {
    /**
     * 以用户名查询  用户
     * @param username
     * @return
     */
    User findByName(String username);
}
