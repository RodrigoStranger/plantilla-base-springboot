package com.example.demo.service.impl;

import com.example.demo.exception.PersonaDuplicadaException;
import com.example.demo.repository.IPersonaRepository;
import com.example.demo.service.IPersonaService;
import com.example.demo.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPersonaServiceImpl implements IPersonaService {

    private final IPersonaRepository personaRepository;

    public IPersonaServiceImpl(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public Persona crearPersona(Persona persona) {
        Persona existentePorNombre = personaRepository.findByNombre(persona.getNombre());
        Persona existentePorApellido = personaRepository.findByApellido(persona.getApellido());
        if (existentePorNombre != null && existentePorApellido != null) {
            throw new PersonaDuplicadaException("Ya existe una persona con ese nombre y apellido.");
        }
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        Persona existente = personaRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        Persona existentePorNombre = personaRepository.findByNombre(persona.getNombre());
        Persona existentePorApellido = personaRepository.findByApellido(persona.getApellido());
        if (existentePorNombre != null && existentePorApellido != null &&
            (!existentePorNombre.getId().equals(id) || !existentePorApellido.getId().equals(id))) {
            throw new PersonaDuplicadaException("Ya existe otra persona con ese nombre y apellido.");
        }
        existente.setNombre(persona.getNombre());
        existente.setApellido(persona.getApellido());
        return personaRepository.save(existente);
    }

    @Override
    public void eliminarPersonaPorId(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }
}