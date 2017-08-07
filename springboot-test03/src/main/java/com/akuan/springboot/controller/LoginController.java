package com.akuan.springboot.controller;

import com.akuan.springboot.entity.UserEntity;
import com.akuan.springboot.exception.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: LoginController
 * @Description: LoginController
 * @author: zhaozhenkuan
 * @date: 2017-07-27 下午4:31
 * @version: V1.0
 */
@Controller
public class LoginController {
    @Value("${spring.test.name:小明}")
    private String name;
    static ConcurrentHashMap<String, UserEntity> map = new ConcurrentHashMap<>();

    static {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("小明");
        userEntity.setPassword("123456");
        userEntity.setAddress("望京中国锦");
        userEntity.setAge(18);
        map.put(userEntity.getName(), userEntity);
    }

    @RequestMapping(value = "/")
    public String index() {

        System.out.println(name);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String name, String password) {
        UserEntity userEntity = map.get(name);

        if (userEntity == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!userEntity.getPassword().equals(password)) {
            throw new MyException("用户名密码错误");
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", userEntity);

        return modelAndView;

    }
}
