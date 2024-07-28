package com.clientepersona.microservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    public void shouldTestGettersAndSetters() {
        Cliente cliente = new Cliente();
        
        // Set values
        cliente.setClienteId(1L);
        cliente.setNombre("Anakin Skywalker");
        cliente.setGenero("Masculino");
        cliente.setEdad(30);
        cliente.setIdentificacion("12345678");
        cliente.setDireccion("Quito");
        cliente.setTelefono("123-1234");
        cliente.setContrasena("password");
        cliente.setEstado("activo");

        // Assert values
        assertEquals(1L, cliente.getClienteId());
        assertEquals("Anakin Skywalker", cliente.getNombre());
        assertEquals("Masculino", cliente.getGenero());
        assertEquals(30, cliente.getEdad());
        assertEquals("12345678", cliente.getIdentificacion());
        assertEquals("Quito", cliente.getDireccion());
        assertEquals("123-1234", cliente.getTelefono());
        assertEquals("password", cliente.getContrasena());
        assertEquals("activo", cliente.getEstado());
    } 
   
}
