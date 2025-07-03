package ru.rezzaklalala.nerzon1.service;

import lombok.Setter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Setter
public class MessageSendler {

    @Value("${queue.name}")
    private String queueName;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message){
        System.out.println("⏩ Отправка в RabbitMQ: " + message);
        amqpTemplate.convertAndSend(queueName, message);
    }
}
