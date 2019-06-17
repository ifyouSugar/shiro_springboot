package com.Still.controller;

import com.Still.domain.User;
import com.Still.domain.entity.Result;
import com.Still.service.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 23:06
 **/
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private ILoginService loginService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> map){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(map);
        try {
            AuthenticationToken tokan = new UsernamePasswordToken(map.get("username"),map.get("password"));

            subject.login(tokan);
            return new Result(true,"登陆成功！");
        } catch (AuthenticationException e) {
            return new Result(false,"登陆失败："+e.getMessage());
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public Result logout(){
        return new Result(true,"成功退出");
    }



    @RequestMapping("/test")
    public String test(){
        String names = "qaq";
        User qaq = loginService.findByName(names);
        String name = qaq.getName();
        return name;
    }



}
