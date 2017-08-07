package com.akuan.springboot.controller;

import com.akuan.springboot.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: UserController
 * @Description: UserController
 * @author: zhaozhenkuan
 * @date: 2017-07-27 下午2:45
 * @version: V1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static ConcurrentHashMap<Long, UserEntity> map = new ConcurrentHashMap<>();

    /**
     * 增
     *
     * @param userEntity
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserEntity postUser(@ModelAttribute("userEntity") UserEntity userEntity) {
        if (userEntity != null) {
            map.put(userEntity.getId(), userEntity);
        }
        return userEntity;

    }

    /**
     * 删
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public UserEntity deleteUser(@PathVariable("id") Long id) {
        return map.remove(id);
    }

    /**
     * 改
     *
     * @param id
     * @param userEntity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserEntity postUser(@PathVariable("id") Long id, @ModelAttribute("userEntity") UserEntity userEntity) {
        return map.put(id, userEntity);
    }

    /**
     * 查
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable("id") Long id) {
        return map.get(id);
    }

    /**
     * 批量查
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserEntity> listUser() {
        return new ArrayList<>(map.values());
    }


}
