package com.micro1.Persona.service;

import com.micro1.Persona.config.RabbitMQConfig;
import com.micro1.Persona.entity.Cliente;
import com.micro1.Persona.repository.ClienteRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Cliente save(Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, savedCliente);
        return savedCliente;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
