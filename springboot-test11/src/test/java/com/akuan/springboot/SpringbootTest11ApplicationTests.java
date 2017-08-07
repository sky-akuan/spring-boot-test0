package com.akuan.springboot;

import com.akuan.springboot.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest11ApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    @Test
    public void testRedis() {
	    String key1 = "key1";
	    String value1 = "value1";
        stringRedisTemplate.opsForValue().set(key1,value1);
        System.out.println(stringRedisTemplate.opsForValue().get(key1));
        Assert.assertEquals(value1,stringRedisTemplate.opsForValue().get(key1));

        User user = new User("小明",18);
        redisTemplate.opsForValue().set("user1",user);
        System.out.println(redisTemplate.opsForValue().get("user1"));
    }
}
