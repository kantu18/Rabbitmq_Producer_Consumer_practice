package com.example.demo.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQ_Consumer {

    private  static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQ_Consumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void Consume(String message)
    {
        LOGGER.info(String.format("Received incoming Messages -->",message));
    }
}
