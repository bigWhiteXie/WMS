package com.tjut.storage.config;

import com.tjut.common.exception.WmsException;

import com.tjut.storage.mq.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private MessageSender messageSender;

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String msgId = correlationData.getId();
        if (ack) {
            log.info("消息 {} 成功发送给mq", msgId);
        } else {
        	WmsException.cast(501,"发送消息失败");
            log.info("消息 {} 发送mq失败", msgId);
        }
    }
}