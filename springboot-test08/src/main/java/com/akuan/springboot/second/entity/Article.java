package com.akuan.springboot.second.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName: Article
 * @Description: 文章
 * @author: zhaozhenkuan
 * @date: 2017-07-28 下午6:29
 * @version: V1.0
 */
@Entity
@Data
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String title;

    public Article() {
        super();
    }

    public Article(String author, String title) {
        this.author = author;
        this.title = title;
    }
}
