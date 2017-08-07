package com.akuan.springboot.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FruitEntity
 * @Description: fruit
 * @author: zhaozhenkuan
 * @date: 2017-07-27 上午10:51
 * @version: V1.0
 */
@Component
@Data
public class FruitEntity {
    @Value("${apple}")
    private String apple;

    @Value("${banana}")
    private String banana;

    @Value("${orange}")
    private String orange;

}
