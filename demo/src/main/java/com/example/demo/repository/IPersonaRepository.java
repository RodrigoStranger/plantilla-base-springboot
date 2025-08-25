package com.example.demo.repository;

import com.example.demo.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository  extends JpaRepository<Persona, Long> {
    Persona findByNombre(String nombre);

    Persona findByApellido(String apellido);
}
