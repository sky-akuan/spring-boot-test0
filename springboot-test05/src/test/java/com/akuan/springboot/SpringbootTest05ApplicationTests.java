package com.akuan.springboot;

import com.akuan.springboot.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest05ApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUser() {
        //增
        Assert.assertEquals(1, userService.saveUser("xiaoming", 18));
        //改
        Assert.assertEquals(1, userService.updateUser("xiaoming", 20));
        //查
        Assert.assertEquals(20, userService.getUser("xiaoming").getAge().longValue());
        //删
        Assert.assertEquals(1, userService.deleteUser("xiaoming"));
    }

}
