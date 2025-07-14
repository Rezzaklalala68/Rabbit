package ru.rezzaklalala.nerzon1.service;

import lombok.Setter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSendler {

    @Value("${queue.name}")
    private String queueName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }



    public void send(String message){
        System.out.println("⏩ Отправка в RabbitMQ: " + message);
        rabbitTemplate.convertAndSend("",queueName, message);
        System.out.println("Сообщение доставлено" );
    }
}
