package com.clientepersona.microservice.integration;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.clientepersona.microservice.model.Cliente;
import com.clientepersona.microservice.repository.ClienteRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        clienteRepository.deleteAll();
    }

    @Test
    public void testCreateCliente() throws Exception {
        String clienteJson = "{\"clienteId\":\"123\",\"contrasena\":\"password\",\"estado\":\"activo\",\"nombre\":\"Anakin\",\"genero\":\"M\",\"edad\":30,\"identificacion\":\"12345678\",\"direccion\":\"Calle Falsa 123\",\"telefono\":\"555-1234\"}";

        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clienteJson))
                .andExpect(jsonPath("$.clienteId", is(123)))
                .andExpect(jsonPath("$.nombre", is("Anakin")));
    }

    @Test
    public void testGetClienteById() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setClienteId(Long.valueOf("123"));
        cliente.setContrasena("pass123");
        cliente.setEstado("activo");
        cliente.setNombre("Anakin Skywalker");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setIdentificacion("12345678");
        cliente.setDireccion("Curuscant 123");
        cliente.setTelefono("123-456");
        clienteRepository.save(cliente);

        mockMvc.perform(get("/clientes/{id}", cliente.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteId", is(123)))
                .andExpect(jsonPath("$.nombre", is("Anakin Skywalker")));
    }

    @Test
    public void testUpdateCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setClienteId(Long.valueOf("123"));
        cliente.setContrasena("pass1234");
        cliente.setEstado("activo");
        cliente.setNombre("Anakin Skywalker");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setIdentificacion("12345678");
        cliente.setDireccion("Curuscant 1234");
        cliente.setTelefono("123-4567");
        clienteRepository.save(cliente);

        String updatedClienteJson = "{\"clienteId\":\"123\",\"contrasena\":\"password\",\"estado\":\"inactivo\",\"nombre\":\"Luke\",\"genero\":\"M\",\"edad\":30,\"identificacion\":\"12345678\",\"direccion\":\"Calle Falsa 123\",\"telefono\":\"321-1234\"}";

        mockMvc.perform(put("/clientes/{id}", cliente.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedClienteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado", is("inactivo")));
    }    
}