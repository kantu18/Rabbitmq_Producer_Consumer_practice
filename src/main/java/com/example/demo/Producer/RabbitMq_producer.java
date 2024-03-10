package com.example.demo.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMq_producer {

    @Value("${rabbitmq.exchange.name}")
    public String exchange;

    @Value("${rabbitmq.routing.key}")
    public String routing_key;

    private  static final Logger LOGGER= LoggerFactory.getLogger(RabbitMq_producer.class);
    public RabbitTemplate rabbitTemplate;

    public RabbitMq_producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void Send_Message(String message)
    {
        LOGGER.info(String.format("MESSAGE SENT -->", message));
        rabbitTemplate.convertAndSend(exchange,routing_key,message);
    }
}
