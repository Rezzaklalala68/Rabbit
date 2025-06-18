package ru.rezzaklalala.nerzon1.config;

import com.rabbitmq.client.AMQP;
import lombok.Setter;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
public class RabbitConfig {

    @Value("${queue.name}")
    private String queueName;

    @Bean
    public Queue queue(){
        return new Queue("First queue", false);
    }
}
