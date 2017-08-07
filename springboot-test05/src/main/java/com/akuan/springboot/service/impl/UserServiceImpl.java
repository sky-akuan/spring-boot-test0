package com.akuan.springboot.service.impl;

import com.akuan.springboot.entity.UserEntity;
import com.akuan.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: UserServiceImpl
 * @author: zhaozhenkuan
 * @date: 2017-07-28 下午2:53
 * @version: V1.0
 */
@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveUser(String name, Integer age) {
        return jdbcTemplate.update("INSERT INTO USER(NAME,AGE) VALUES (?,?)", name, age);
    }

    @Override
    public int deleteUser(String name) {
        return jdbcTemplate.update("DELETE FROM USER WHERE NAME = ?", name);
    }

    @Override
    public int updateUser(String name, Integer age) {
        return jdbcTemplate.update("UPDATE  USER SET AGE = ? WHERE NAME = ?", age, name);
    }

    @Override
    public UserEntity getUser(String name) {
        List<UserEntity> userList = jdbcTemplate.query("SELECT * FROM USER WHERE NAME = ?",
                new BeanPropertyRowMapper<UserEntity>(UserEntity.class), name);

        return userList != null ? userList.get(0) : null;
    }

}
