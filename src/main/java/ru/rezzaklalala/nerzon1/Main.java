package ru.rezzaklalala.nerzon1;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Main {
    public static void main(String[] args) {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (
                Connection connection = factory.newConnection()) {
            System.out.println("Connected to RabbitMQ!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
