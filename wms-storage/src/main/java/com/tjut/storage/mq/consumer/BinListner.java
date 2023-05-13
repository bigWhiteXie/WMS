package com.tjut.storage.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.tjut.storage.model.po.MdBin;
import com.tjut.storage.config.MqQueueConfig;
import com.tjut.storage.service.MdBinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class BinListner {

    @Autowired
    private MdBinService mdBinService;

    /**
     * 批量进行商品导入
     */
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = MqQueueConfig.QUEUE_BIN),
//            exchange = @Exchange(name = MqQueueConfig.EXCHANGE_STORAGE),
//            key = {"bin.*"}
//    ))
    @RabbitListener(queues = MqQueueConfig.QUEUE_BIN)
    public void binImport(Message message, Channel channel) throws Exception {
        String msg = new String(message.getBody());
        log.info("queue@bin 收到的消息为: {}", msg);
        List<MdBin> goodsList = JSON.parseArray(msg, MdBin.class);
        try {
            // 这里写各种业务逻辑
            mdBinService.saveBatch(goodsList);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            //拒绝该消息后转发到死信队列
            log.info("queue@bin 消费失败，发送到死信队列: {}", msg);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }

    /**
     * 批量进行商品导入
     */
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = "bin-dlx-queue"),
//            exchange = @Exchange(name = MqQueueConfig.EXCHANGE_STORAGE_DEAD),
//            key = {"bin.dead"}
//    ))
    @RabbitListener(queues = MqQueueConfig.QUEUE_BIN_DEAD)
    public void binDeadHandler(Message message, Channel channel) throws Exception {
        String msg = new String(message.getBody());
        log.info("死信队列 收到的消息为: {}", msg);
        List<MdBin> binList = JSON.parseArray(msg, MdBin.class);

        // 这里写各种业务逻辑
        for (MdBin bin : binList) {
            try {
                mdBinService.save(bin);
            }catch (Exception e){
                log.error("导入储位记录失败，记录：{}",bin);
            }
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }
}