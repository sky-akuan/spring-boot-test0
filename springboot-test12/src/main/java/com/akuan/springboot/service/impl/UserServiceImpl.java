package com.akuan.springboot.service.impl;

import com.akuan.springboot.domain.User;
import com.akuan.springboot.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: UserServiceImpl
 * @Description: UserServiceImpl
 * @author: zhaozhenkuan
 * @date: 2017-08-03 下午2:51
 * @version: V1.0
 */
@Service
public class UserServiceImpl implements UserService {
    private static ConcurrentHashMap<String, User> map = new ConcurrentHashMap<>();

    static {
        User user = new User("小明", 15);
        map.put(user.getName(), user);
    }

    @Override
    @CachePut(key = "#p0.name", value = "user")
    public User addUser(User user) {
        System.out.println("UserServiceImpl.addUser" + user);
        map.put(user.getName(), user);
        return user;

    }

    @Override
    @CacheEvict(key = "#p0.name", value = "user")
    public void deleteUser(User user) {
        System.out.println("UserServiceImpl.deleteUser" + user);
        map.remove(user.getName());
    }

    @Override
    @CachePut(key = "#p0.name", value = "user")
    public User updateUser(User user) {
        System.out.println("UserServiceImpl.updateUser" + user);
        map.put(user.getName(), user);
        return user;

    }

    @Override
    @Cacheable(key = "#p0.name", value = "user")
    public User getUser(User user) {
        System.out.println("UserServiceImpl.getUser" + user);
        return map.get(user.getName());
    }
}
