package com.akuan.springboot;

import com.akuan.springboot.producer.KafkaProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest15ApplicationTests {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    public void testKafka() throws InterruptedException {
        kafkaProducer.sendDefault("111", "message1");

        Thread.sleep(100000);
    }

}
