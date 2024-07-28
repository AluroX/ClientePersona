package com.clientepersona.microservice.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.clientepersona.microservice.model.Cliente;
import com.clientepersona.microservice.repository.ClienteRepository;

public class ClienteServiceTests {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSaveCliente() {
        
        Cliente cliente = new Cliente();
        cliente.setClienteId(Long.valueOf("123"));
        cliente.setContrasena("pass123");
        cliente.setEstado("activo");

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente savedCliente = clienteService.save(cliente);

        assertNotNull(savedCliente);
        assertEquals(Long.valueOf("123"), savedCliente.getClienteId());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void shouldFindById() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setClienteId(Long.valueOf("123"));
        cliente.setContrasena("pass123");
        cliente.setEstado("activo");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> foundCliente = clienteRepository.findById(1L);

        assertNotNull(foundCliente);
        assertEquals(Long.valueOf("123"), foundCliente.get().getClienteId());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    public void shouldDeleteCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        doNothing().when(clienteRepository).deleteById(1L);

        clienteService.delete(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
    }
}
