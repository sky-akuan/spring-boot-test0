package com.akuan.springboot.producer;

import com.akuan.springboot.RabbitMqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * @ClassName: RabbitMqProducer
 * @Description: RabbitMqProducer
 * @author: zhaozhenkuan
 * @date: 2017-08-03 下午8:44
 * @version: V1.0
 */
@Service
public class RabbitMqProducer implements RabbitTemplate.ConfirmCallback {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("RabbitMqProducer.confirm;" + ack);
    }

    public void directSend(String message) {
        CorrelationData data = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMqConfig.DIRECT_EXCHANGE, RabbitMqConfig.DIRECT_ROUTING_KEY, message, data);
    }

    public void topicSend(String message) {
        CorrelationData data = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE, "topic", message, data);
    }


}
