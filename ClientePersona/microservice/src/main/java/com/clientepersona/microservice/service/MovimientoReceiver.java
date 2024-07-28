package com.clientepersona.microservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MovimientoReceiver {

    @RabbitListener(queues = "movimientoQueue")
    public void receiveMessage(String mensaje) {
        System.out.println("Mensaje recibido: " + mensaje);
    }
}
