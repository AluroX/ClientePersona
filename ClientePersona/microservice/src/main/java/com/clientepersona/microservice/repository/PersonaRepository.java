package com.clientepersona.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientepersona.microservice.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {}