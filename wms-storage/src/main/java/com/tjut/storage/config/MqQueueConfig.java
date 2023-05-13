package com.tjut.storage.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class MqQueueConfig {
    public static final String EXCHANGE_STORAGE = "Exchange@topic.storage";
    public static final String QUEUE_BIN = "Queue@bin";
    public static final String RK_STORAGE_BIN = "bin.*";

    public static final String EXCHANGE_STORAGE_DEAD = "storage-dlx-exchange";
    public static final String QUEUE_BIN_DEAD = "bin-dlx-queue";
    public static final String RK_BIN_DEAD = "bin.dead";

    //死信队列配置
//    @Bean
//    public DirectExchange DeadDirectExchange() {
//        return new DirectExchange(EXCHANGE_STORAGE_DEAD, true, false);
//    }
//
//    @Bean
//    public Queue deadQueueBin() {
//        return new Queue(QUEUE_BIN_DEAD, true, false, false, null);
//    }
//
//    @Bean
//    public Binding deadBinding() {
//        return BindingBuilder.bind(deadQueueBin()).to(DeadDirectExchange()).with(RK_BIN_DEAD);
//    }
//
//
//    // 正常业务队列配置
//    @Bean
//    public TopicExchange businessTopicExchange() {
//        return new TopicExchange(EXCHANGE_STORAGE_DEAD, true, false);
//    }
//
//
//    @Bean
//    public Queue businessQueueBin() {
//        Map<String, Object> args = new HashMap<>();
//        // x-dead-letter-exchange：这里声明当前业务队列绑定的死信交换机
//        args.put("x-dead-letter-exchange", EXCHANGE_STORAGE_DEAD);
//        // x-dead-letter-routing-key：这里声明当前业务队列的死信路由 key
//        args.put("x-dead-letter-routing-key", RK_BIN_DEAD);
//        return new Queue(QUEUE_BIN, true, false, false, args);
//    }
//
//
//
//    // 业务队列 A 与交换机绑定，并指定 Routing_Key
//    @Bean
//    public Binding businessBindingA() {
//        return BindingBuilder.bind(businessQueueBin()).to(businessTopicExchange()).with(RK_STORAGE_BIN);
//    }
//
//



    // --------------------------使用 RabbitAdmin 启动服务便创建交换机和队列--------------------------
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        // 只有设置为 true，spring 才会加载 RabbitAdmin 这个类
//        rabbitAdmin.setAutoStartup(true);
//        // 创建死信交换机和对列
//        rabbitAdmin.declareExchange(DeadDirectExchange());
//        rabbitAdmin.declareQueue(deadQueueBin());
//        // 创建业务交换机和对列
//        rabbitAdmin.declareExchange(businessTopicExchange());
//        rabbitAdmin.declareQueue(businessQueueBin());
//
//
//        return rabbitAdmin;
//    }
}
