package com.example.demo.Controller;

import com.example.demo.DTO.USER;
import com.example.demo.Producer.RabbitMQ_JSONproducer;
import com.example.demo.Producer.RabbitMq_producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/V1")
public class RabbitMQ_Controller {
    @Autowired
    RabbitMq_producer rabbitMqProducer;

    @Autowired
    RabbitMQ_JSONproducer rabbitMQJsoNproducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendmessage(@RequestParam("message") String message)
    {
        rabbitMqProducer.Send_Message(message);
        return ResponseEntity.ok("Message Sended Successfully...");
    }

    @PostMapping("/saveorcreate")
    public ResponseEntity<String> sendJSONmessage(@RequestBody USER user)
    {
        rabbitMQJsoNproducer.sendJSONmessage(user);
        return ResponseEntity.ok("Message JSON Sended successfully");
    }
}
