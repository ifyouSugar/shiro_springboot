package com.Still.repository;

import com.Still.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 21:46
 **/
@Mapper
public interface UserRepository {

    /**
     * 以用户名查询  用户
     * @param username
     * @return
     */
    @Select("select * from user where name = #{name}")
    User findByName(String username);
}
