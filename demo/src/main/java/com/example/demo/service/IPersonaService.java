package com.example.demo.service;

import com.example.demo.model.Persona;

import java.util.*;

public interface IPersonaService {
    Persona crearPersona(Persona persona);

    Persona actualizarPersona(Long id, Persona persona);

    void eliminarPersonaPorId(Long id);

    Persona obtenerPersonaPorId(Long id);

    List<Persona> obtenerTodasLasPersonas();
}
