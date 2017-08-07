package com.akuan.springboot.consumer;

import com.akuan.springboot.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RabbitMqConsumer
 * @Description: RabbitMqConsumer
 * @author: zhaozhenkuan
 * @date: 2017-08-03 下午8:45
 * @version: V1.0
 */
@Service
public class RabbitMqConsumer {
    @RabbitListener(queues = RabbitMqConfig.MY_QUEUE_01)
    @RabbitHandler
    public void processQueue01(String message) {
        System.out.println("get message from MY_QUEUE_01: " + message);
    }

    @RabbitListener(queues = RabbitMqConfig.MY_QUEUE_02)
    @RabbitHandler
    public void processQueue02(String message) {
        System.out.println("get message from MY_QUEUE_02: " + message);
    }
}
