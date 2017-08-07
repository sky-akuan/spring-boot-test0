package com.akuan.springboot;

import com.akuan.springboot.domain.User;
import com.akuan.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest12ApplicationTests {
    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserService userService;

    @Test
    public void testCache() {
        System.out.println(cacheManager.getClass());
        String name = "小明";
        Integer age = 18;
        User user = new User(name, age);
        userService.addUser(user);
        System.out.println(userService.getUser(user));
        userService.updateUser(new User(name, 20));
        System.out.println(userService.getUser(user));
        userService.deleteUser(user);
        System.out.println(userService.getUser(user));
    }

}
