package com.tjut.shop.mq;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;



    public void convertAndSend(String exchange, String routingKey, String message) {
        String msgId = UUID.randomUUID().toString();
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(msgId);
        rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
    }

    public String dequeueUnAckMsg(String msgId) {
        return null;
    }

}