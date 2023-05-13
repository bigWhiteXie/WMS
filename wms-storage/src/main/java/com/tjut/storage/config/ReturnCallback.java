package com.tjut.storage.config;

import com.tjut.common.exception.WmsException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReturnCallback implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        String msg = new String(message.getBody());

        System.out.println(String.format("消息 {%s} 不能被正确路由，routingKey为 {%s}", msg, routingKey));
        WmsException.cast(501,"消息不能被正确路由");

    }
}