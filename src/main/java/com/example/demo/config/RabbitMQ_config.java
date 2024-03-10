package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQ_config {

    //Create a queue first with queuename
    @Value("${rabbitmq.queue.name}")
    public String queuename;

    @Bean
    public Queue queue()
    {
        return new Queue(queuename);
    }

    //Create a JSON queue with queuename
    @Value("${rabbitmq.queue.json.name}")
    public String jsonqueuename;

    @Bean
    public Queue json_queue()
    {
        return new Queue(jsonqueuename);
    }

    //Create an exchange next with exchangename
    @Value("${rabbitmq.exchange.name}")
    public String exchange;

    @Bean
    public TopicExchange exchange()
    {
        return new TopicExchange(exchange);
    }

    //Bind the Queue with exchange through Routing_key
    @Value("${rabbitmq.routing.key}")
    public String routingkey;

    @Bean
    public Binding binding()
    {
        return BindingBuilder.bind(queue()).to(exchange()).with(routingkey);
    }

    //Bind the Queue with exchange through JSON Routing_key
    @Value("${rabbitmq.routing.json.key}")
    public String routingkeyjson;

    @Bean
    public Binding JSONbinding()
    {
        return BindingBuilder.bind(json_queue()).to(exchange()).with(routingkeyjson);
    }

    @Bean
    public Jackson2JsonMessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
