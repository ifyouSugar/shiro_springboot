package com.Still;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 19:06
 **/
@MapperScan("com.Still.repository")
@SpringBootApplication
public class ShiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class,args);
    }

}
