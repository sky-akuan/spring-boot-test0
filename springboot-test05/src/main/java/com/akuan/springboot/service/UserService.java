package com.akuan.springboot.service;

import com.akuan.springboot.entity.UserEntity;

/**
 * @ClassName: UserService
 * @Description: UserService
 * @author: zhaozhenkuan
 * @date: 2017-07-28 下午2:44
 * @version: V1.0
 */
public interface UserService {
    int saveUser(String name, Integer age);

    int deleteUser(String name);

    int updateUser(String name, Integer age);

    UserEntity getUser(String name);
}
