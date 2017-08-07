package com.akuan.springboot;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public final static String MY_QUEUE_01 = "MY_QUEUE_01";
    public final static String MY_QUEUE_02 = "MY_QUEUE_02";

    public final static String TOPIC_EXCHANGE = "topicExchange";
    public final static String DIRECT_EXCHANGE = "directExchange";

    public final static String DIRECT_ROUTING_KEY = "directRoutingKey";
    public final static String TOPIC_ROUTING_KEY = "topic.#";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("127.0.0.1:5672");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }
    //创建队列
    @Bean
    public Queue queueMessage01() {
        return new Queue(RabbitMqConfig.MY_QUEUE_01);
    }

    @Bean
    public Queue queueMessage02() {
        return new Queue(RabbitMqConfig.MY_QUEUE_02);
    }

    //创建交换器
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }


    @Bean
    Binding bindingExchangeMessage01() {
        return BindingBuilder.bind(queueMessage01()).to(directExchange()).with(DIRECT_ROUTING_KEY);
    }

    @Bean
    Binding bindingExchangeMessage02() {
        return BindingBuilder.bind(queueMessage02()).to(topicExchange()).with(TOPIC_ROUTING_KEY);
    }

}