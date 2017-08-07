package com.akuan.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MapperConfigFirst
 * @Description: MapperConfigFirst
 * @author: zhaozhenkuan
 * @date: 2017-07-31 下午3:29
 * @version: V1.0
 */
@Configuration
@MapperScan(basePackages = "com.akuan.springboot.first.mapper",sqlSessionFactoryRef = "firstSqlSessionFactory")
public class MapperConfigFirst {

}
