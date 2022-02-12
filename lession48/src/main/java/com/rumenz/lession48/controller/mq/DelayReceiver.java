package com.rumenz.lession48.controller.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @className: FanoutReceiver
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com
 * @date: 2022/2/9
 **/
@Component
public class FanoutReceiver {

    @RabbitHandler
    @RabbitListener(queues = "rumenzDelay")
    public void receiverOne(Message msg, Channel channel) throws IOException {
        byte[] body = msg.getBody();
        System.out.println("延迟消息:"+new String(body,"UTF-8"));
        //手动确认消息消费
        channel.basicAck(msg.getMessageProperties().getDeliveryTag(),true);

    }
}
