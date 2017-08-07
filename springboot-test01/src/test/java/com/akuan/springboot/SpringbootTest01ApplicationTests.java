package com.akuan.springboot;

import com.akuan.springboot.controller.Test01Controller;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest01ApplicationTests {
    @Autowired
    private Test01Controller test01Controller;

    @Test
    public void contextLoads() {
        Assert.assertEquals("springboot练习", test01Controller.getTask());

    }

}
