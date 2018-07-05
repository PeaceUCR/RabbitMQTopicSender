package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConfig {

    public static final String queue1Name = "queue1";
    public static final String routingKey1= "adam.he.#";

    public static final String queue2Name = "queue2";
    public static final String routingKey2= "ping.he.#";

    public static final String topicExchangeName = "my-rabbit-exchange";
    //config queue
    @Bean(name = "q1")
    Queue queue1(){
        return new Queue(queue1Name, false)  ;
    }

    @Bean(name = "q2")
    Queue queue2(){
        return new Queue(queue2Name, false)  ;
    }

    @Bean(name ="topic")
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }
    //routing to different queue with different key
    @Bean
    Binding binding1(@Qualifier("q1") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey1);
    }

    @Bean
    Binding binding2(@Qualifier("q2") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey2);
    }

}
