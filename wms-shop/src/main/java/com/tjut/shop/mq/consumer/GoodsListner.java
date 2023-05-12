package com.tjut.shop.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.tjut.shop.model.po.MdGoods;
import com.tjut.shop.service.MdGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class GoodsListner {

    @Autowired
    private MdGoodsService mdGoodsService;

    /**
     * 批量进行商品导入
     */
    @RabbitListener(queues = "Queue@goods")
    public void goodsImport(Message message, Channel channel) throws Exception {
        String msg = new String(message.getBody());
        log.info("queue@goods 收到的消息为: {}", msg);
        List<MdGoods> goodsList = JSON.parseArray(msg, MdGoods.class);
        try {
            // 这里写各种业务逻辑
            mdGoodsService.saveBatch(goodsList);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            //拒绝该消息后转发到死信队列
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }

    /**
     * 批量进行商品导入
     */
    @RabbitListener(queues = "goods-dlx-queue")
    public void goodsDeadHandler(Message message, Channel channel) throws Exception {
        String msg = new String(message.getBody());
        log.info("infoLogQueue 收到的消息为: {}", msg);
        List<MdGoods> goodsList = JSON.parseArray(msg, MdGoods.class);

        // 这里写各种业务逻辑
        for (MdGoods goods : goodsList) {
            try {
                mdGoodsService.save(goods);
            }catch (Exception e){
                log.error("导入商品记录失败，记录：{}",goods);
            }
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }
}