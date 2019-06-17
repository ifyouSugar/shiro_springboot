package com.Still.service.impl;

import com.Still.domain.User;
import com.Still.repository.UserRepository;
import com.Still.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 21:43
 **/
@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 以用户名查询  用户
     * @param username
     * @return
     */
    @Override
    public User findByName(String username) {

        User user = userRepository.findByName(username);

        return user;
    }


}
