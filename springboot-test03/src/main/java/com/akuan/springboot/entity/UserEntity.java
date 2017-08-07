package com.akuan.springboot.entity;

import lombok.Data;

/**
 * @ClassName: UserEntity
 * @Description: UserEntity
 * @author: zhaozhenkuan
 * @date: 2017-07-27 下午4:31
 * @version: V1.0
 */
@Data
public class UserEntity {
    private Long id;
    private String name;
    private String password;
    private String address;
    private Integer age;
}
