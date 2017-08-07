package com.akuan.springboot.controller;

import com.akuan.springboot.entity.AuthorEntity;
import com.akuan.springboot.entity.FruitEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: Test01Controller
 * @Description: controller
 * @author: zhaozhenkuan
 * @date: 2017-07-26 下午8:21
 * @version: V1.0
 */
@RestController
@Data
public class Test01Controller {

    @Value("${com.akuan.springboot.author}")
    private String author;

    @Value("${com.akuan.springboot.task}")
    private String task;

    @Value("${com.akuan.springboot.score}")
    private String score;

    @Autowired
    private FruitEntity fruit;

    @Autowired
    private AuthorEntity authorEntity;

    @RequestMapping("/score")
    public String score() {
        System.out.println(authorEntity);
        System.out.println(author);
        System.out.println(task);
        System.out.println(score);
        return getScore();
    }

    @RequestMapping("/eat")
    public String eat() {
        return "我爱吃" + fruit;
    }

}
