package com.tjut.shop.mq;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class MqQueueConfig {
    public static final String EXCHANGE_SHOP = "Exchange@topic.shop";
    public static final String QUEUE_GOODS = "Queue@goods";
    public static final String RK_SHOP_GOODS = "goods.import";

    public static final String EXCHANGE_GOODS_DEAD = "goods-dlx-exchange";
    public static final String QUEUE_GOODS_DEAD = "goods-dlx-queue";
    public static final String RK_GOODS_DEAD = "goods-dlx-queue";



    // --------------------------正常业务队列--------------------------

    // goods队列
    @Bean
    public Queue businessQueueA() {
        Map<String, Object> args = new HashMap<>();
        // x-dead-letter-exchange：这里声明当前业务队列绑定的死信交换机
        args.put("x-dead-letter-exchange", EXCHANGE_GOODS_DEAD);
        // x-dead-letter-routing-key：这里声明当前业务队列的死信路由 key
        args.put("x-dead-letter-routing-key", RK_GOODS_DEAD);
        return new Queue(QUEUE_GOODS, true, false, false, args);
    }

    // goods死信队列
    @Bean
    public Queue businessQueueB() {

        return new Queue(QUEUE_GOODS_DEAD, true, false, false, null);
    }

    // shop交换机
    @Bean
    public TopicExchange businessTopicExchange() {
        return new TopicExchange(EXCHANGE_SHOP, true, false);
    }

    @Bean
    public DirectExchange DeadDirectExchange() {
        return new DirectExchange(EXCHANGE_GOODS_DEAD, true, false);
    }

    // 业务队列 A 与交换机绑定，并指定 Routing_Key
    @Bean
    public Binding businessBindingA() {
        return BindingBuilder.bind(businessQueueA()).to(businessTopicExchange()).with(RK_SHOP_GOODS);
    }



    // --------------------------使用 RabbitAdmin 启动服务便创建交换机和队列--------------------------
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        // 只有设置为 true，spring 才会加载 RabbitAdmin 这个类
//        rabbitAdmin.setAutoStartup(true);
//        // 创建死信交换机和对列
//        rabbitAdmin.declareExchange(deadLetterDirectExchange());
//        rabbitAdmin.declareQueue(deadLetterQueueA());
//        rabbitAdmin.declareQueue(deadLetterQueueB());
//        // 创建业务交换机和对列
//        rabbitAdmin.declareExchange(businessTopicExchange());
//        rabbitAdmin.declareQueue(businessQueueA());
//        rabbitAdmin.declareQueue(businessQueueB());
//        return rabbitAdmin;
//    }
}
