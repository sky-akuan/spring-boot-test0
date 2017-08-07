package com.akuan.springboot.domain;

import lombok.Data;


@Data
public class User {
    private Long id;
    private String name;
    private Integer age;

    public User() {
        super();
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}