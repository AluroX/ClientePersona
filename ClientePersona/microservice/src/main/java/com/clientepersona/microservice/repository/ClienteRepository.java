package com.clientepersona.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientepersona.microservice.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}

