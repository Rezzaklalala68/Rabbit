package ru.rezzaklalala.nerzon1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.*;

class MessageSendlerTest {
    @Mock
    RabbitTemplate rabbitTemplate;
    @InjectMocks
    MessageSendler messageSendler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSend() {
        messageSendler.send("message");
        verify(rabbitTemplate).convertAndSend(anyString(), anyString(), any(Object.class));
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme