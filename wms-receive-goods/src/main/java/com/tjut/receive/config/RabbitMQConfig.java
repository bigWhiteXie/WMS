package com.tjut.receive.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue simpleQueue(){
        return new Queue("receiveGoods.queue");
    }

    @Bean
    public DirectExchange simpleExchange(){
        return new DirectExchange("receiveGoods.direct");
    }

    @Bean
    public Binding bindingQueue1(Queue simpleQueue,DirectExchange simpleExchange){
        return BindingBuilder.bind(simpleQueue).to(simpleExchange).with("receive.good");
    }
}
