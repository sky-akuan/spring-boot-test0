package com.akuan.springboot.controller;

import com.akuan.springboot.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
//@Api(value = "登录controller", tags = "登录", position = 1)
@Controller
public class LoginController {
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

//    @ApiOperation(value = "首页", hidden = true)
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

//    @ApiOperation(value = "登录")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(value = "用户名", name = "name", paramType = "query"),
                    @ApiImplicitParam(value = "密码", name = "password", paramType = "query"),
            }
    )
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String name, String password) {
        UserEntity userEntity = map.get(name);

        if (userEntity == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!userEntity.getPassword().equals(password)) {
            throw new RuntimeException("用户名密码错误");
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", userEntity);

        return modelAndView;

    }
}
