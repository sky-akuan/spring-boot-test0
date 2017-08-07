package com.akuan.springboot.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

/**
 * @ClassName: KafkaConsumer
 * @Description: KafkaConsumer
 * @author: zhaozhenkuan
 * @date: 2017-08-04 上午11:01
 * @version: V1.0
 */
@Service
@Slf4j
public class KafkaConsumer implements AcknowledgingMessageListener<String, String> {
    @KafkaListener(topics = {"default"})
    @Override
    public void onMessage(ConsumerRecord<String, String> data, Acknowledgment acknowledgment) {
        log.info("接受消息data={}", data);
        acknowledgment.acknowledge();
    }


}
