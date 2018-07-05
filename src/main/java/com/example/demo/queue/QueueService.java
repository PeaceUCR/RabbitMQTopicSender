package com.example.demo.queue;

public interface QueueService {
    public void sendMessage(String msg, String routingKey);
}