package com.clientepersona.microservice.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Cliente extends Persona {
    private Long clienteId;
    private String contrasena;
    private String estado;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}