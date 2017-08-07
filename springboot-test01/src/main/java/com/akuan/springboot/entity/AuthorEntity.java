package com.akuan.springboot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AuthorEntity
 * @Description: AuthorEntity
 * @author: zhaozhenkuan
 * @date: 2017-08-02 下午5:39
 * @version: V1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "com.akuan.springboot")
public class AuthorEntity {
    private String author;
    private String task;
    private String score;
}
