package com.example.demo.Consumer;

import com.example.demo.DTO.USER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQ_JSON_Consumer {

    private  static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQ_JSON_Consumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void ConsumeJSON(USER user)
    {
        LOGGER.info(String.format("Received incoming Messages -->",user));
    }
}
