package com.akuan.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloWorldController
 * @Description: hello world
 * @author: zhaozhenkuan
 * @date: 2017-07-26 下午7:32
 * @version: V1.0
 */
@RestController
public class HelloWorldController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String helloWorld() {
        logger.info("测试 hello  spring  boot ");
        logger.error("测试 hello  spring  boot ");
        return "hello spring boot";
    }

}
