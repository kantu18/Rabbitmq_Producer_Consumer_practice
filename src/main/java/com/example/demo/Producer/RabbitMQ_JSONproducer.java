package com.example.demo.Producer;

import com.example.demo.DTO.USER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQ_JSONproducer {

    @Value("${rabbitmq.routing.json.key}")
    public String routingkeyjson;

    @Value("${rabbitmq.exchange.name}")
    public String exchange;
    private  static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQ_JSONproducer.class);
    public RabbitTemplate rabbitTemplate;
    public RabbitMQ_JSONproducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJSONmessage(USER user)
    {
        LOGGER.info(String.format("MESSAGE SENT -->", user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingkeyjson,user);
    }
}
