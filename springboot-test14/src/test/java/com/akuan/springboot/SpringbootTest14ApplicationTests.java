package com.akuan.springboot;

import com.akuan.springboot.producer.RabbitMqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest14ApplicationTests {

    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Test
    public void testRabbitMq() {
        rabbitMqProducer.directSend("通过directExchange 发送消息");
        rabbitMqProducer.topicSend("通过topicExchange 发送消息");

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
