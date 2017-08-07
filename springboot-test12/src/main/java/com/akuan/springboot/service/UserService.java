package com.akuan.springboot.service;

import com.akuan.springboot.domain.User;

/**
 * @ClassName: UserService
 * @Description: UserService
 * @author: zhaozhenkuan
 * @date: 2017-08-03 下午2:51
 * @version: V1.0
 */
public interface UserService {
    User addUser(User user);

    void deleteUser(User user);

    User updateUser(User user);

    User getUser(User user);
}
