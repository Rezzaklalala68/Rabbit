package ru.rezzaklalala.nerzon1.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class MessageSendlerTest {
    @Mock
    org.springframework.amqp.rabbit.core.RabbitTemplate rabbitTemplate;
    @InjectMocks
    ru.rezzaklalala.nerzon1.service.MessageSendler messageSendler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSend(){
        messageSendler.send("message");
        verify(rabbitTemplate).convertAndSend(anyString(), anyString(), any(java.lang.Object.class));
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme