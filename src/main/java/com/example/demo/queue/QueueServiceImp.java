package com.example.demo.queue;

import com.example.demo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QueueServiceImp implements QueueService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String msg, String routingKey) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.topicExchangeName, routingKey, msg);
    }
}
