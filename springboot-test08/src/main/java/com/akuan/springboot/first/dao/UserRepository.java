package com.akuan.springboot.first.dao;

import com.akuan.springboot.first.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName: UserRepository
 * @Description: UserRepository
 * @author: zhaozhenkuan
 * @date: 2017-07-28 下午4:23
 * @version: V1.0
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

}
