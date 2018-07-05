package com.example.demo;


import com.example.demo.config.RabbitMQConfig;
import com.example.demo.queue.QueueServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    QueueServiceImp queueServiceImp;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        queueServiceImp.sendMessage("msg from sender with routingKey 1", RabbitMQConfig.routingKey1);
        queueServiceImp.sendMessage("msg from sender with routingKey 2", RabbitMQConfig.routingKey2);
    }
}
