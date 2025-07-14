package ru.rezzaklalala.nerzon1;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Nerzon1Application {



    public static void main(String[] args) {
        SpringApplication.run(Nerzon1Application.class, args);
    }

}
