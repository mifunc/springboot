package com.rumenz.lession47.controller.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RabbitmqConfig
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com
 * @date: 2022/2/9
 **/
@Configuration
public class RabbitmqConfig {
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback(){
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("数据"+correlationData);
                System.out.println("确认情况"+ack);
                System.out.println("原因"+cause);
            }
        });
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback(){

            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("消息"+returnedMessage.getMessage());
                System.out.println("回应码"+returnedMessage.getReplyCode());
                System.out.println("回应消息"+returnedMessage.getReplyText());
                System.out.println("交换机"+returnedMessage.getExchange());
                System.out.println("路由键"+returnedMessage.getRoutingKey());
            }
        });

        return rabbitTemplate;

    }
}
