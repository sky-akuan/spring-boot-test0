package com.akuan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * 资源文件读取
 * 多环境选择
 */
@SpringBootApplication
@PropertySource(value = {"classpath:fruit.properties"}, encoding = "UTF-8")
public class SpringbootTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest01Application.class, args);
    }
}
