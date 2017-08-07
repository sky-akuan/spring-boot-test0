package com.akuan.springboot.producer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @ClassName: KafkaProducer
 * @Description: KafkaProducer
 * @author: zhaozhenkuan
 * @date: 2017-08-04 上午11:00
 * @version: V1.0
 */
@Service
@Slf4j
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
            @Override
            public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
                log.info("KafkaProducer.onSuccess;topic={},partition={},key={},value={},recordMetadata={}",
                        topic, partition, key, value, JSON.toJSONString(recordMetadata));
            }

            @Override
            public void onError(String topic, Integer partition, String key, String value, Exception exception) {
                log.error("KafkaProducer.onError;topic=" + topic + ",partition=" + partition + ",key=" + key +
                        ",value=" + value, exception);
            }

            @Override
            public boolean isInterestedInSuccess() {
                return true;
            }
        });
    }

    /**
     * @param key
     * @param message
     */
    public void sendDefault(String key, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.sendDefault(key, message);
        future.addCallback(result -> {
            log.info("发送消息到kafka成功, result:{}", JSON.toJSONString(result));
        }, exception -> {
            log.error("发送消息到kafka异常,exception:{},message:{}.", exception.getMessage());
        });
    }

    /**
     * 发送消息
     *
     * @param topic
     * @param key
     * @param message
     */
    public void sendMessage(String topic, String key, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, message);
        future.addCallback(result -> {
            log.info("发送消息到kafka成功, result:{}", JSON.toJSONString(result));
        }, exception -> {
            log.error("发送消息到kafka异常,exception:{},message:{}.", exception.getMessage());
        });
    }


}
