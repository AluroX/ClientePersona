package com.clientepersona.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientepersona.microservice.model.Cliente;
import com.clientepersona.microservice.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findClienteById(Long id) {
        return clienteRepository.findById(id);
    }    

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }    

    public Cliente update(Long id, Cliente cliente) {
        cliente.setClienteId(id);
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
