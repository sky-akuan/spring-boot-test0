package com.akuan.springboot;

import com.akuan.springboot.domain.User;
import com.akuan.springboot.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest09ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMybatis() {

        int result = userMapper.insert("小李子", 21);
        Assert.assertEquals(1, result);

        User user = userMapper.findByName("小李子");
        Assert.assertEquals(21, user.getAge().longValue());


    }

}
