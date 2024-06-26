package com.micro2.Cuenta.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiver {

    @RabbitListener(queues = "personaClienteQueue")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        // Procesar el mensaje
    }
}