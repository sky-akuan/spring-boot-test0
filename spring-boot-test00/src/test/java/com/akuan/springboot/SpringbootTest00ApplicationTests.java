package com.akuan.springboot;

import com.akuan.springboot.controller.HelloWorldController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest00ApplicationTests {
    @Autowired
    HelloWorldController helloWorldController;

    @Test
    public void contextLoads() {
        System.out.println(helloWorldController.helloWorld());
    }

}
