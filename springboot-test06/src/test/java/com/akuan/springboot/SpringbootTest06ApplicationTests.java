package com.akuan.springboot;

import com.akuan.springboot.dao.UserRepository;
import com.akuan.springboot.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest06ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testJpa() {
        userRepository.save(new User("name1",18));
        userRepository.save(new User("name2",19));
        userRepository.save(new User("name3",20));

        User user = userRepository.findByNameAndAge("name1",18);
        System.out.println(user);
        Assert.assertEquals("name1", user.getName());

        User user2 = userRepository.findUser("name2");

        System.out.println(user2);
        Assert.assertEquals("name2",user2.getName());

    }
}
