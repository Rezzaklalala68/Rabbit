package ru.rezzaklalala.nerzon1.config;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import lombok.Setter;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
public class RabbitConfig {

    @Value("${queue.name}")
    private String queueName;

    @Value("${spring.rabbitmq.username}")
    private String userName;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Bean
    public Queue queue(){

        return new Queue(queueName, false);
    }

    @Bean
    CachingConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");

        cachingConnectionFactory.setUsername(userName);
        cachingConnectionFactory.setPassword(password);

        return cachingConnectionFactory;

    }

    @Bean
    public RabbitAdmin rabbitAdmin(){
        return new RabbitAdmin(connectionFactory());
    }

}
