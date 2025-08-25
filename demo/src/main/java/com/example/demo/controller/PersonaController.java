package com.example.demo.controller;

import com.example.demo.service.IPersonaService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Persona;
import java.util.List;
import com.example.demo.exception.PersonaDuplicadaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.crearPersona(persona);
    }

    @PutMapping
    public Persona actualizarPersona(@RequestBody Persona persona) {
        return personaService.actualizarPersona(persona);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersonaPorId(id);
    }

    @GetMapping("/{id}")
    public Persona obtenerPersonaPorId(@PathVariable Long id) {
        return personaService.obtenerPersonaPorId(id);
    }

    @GetMapping
    public List<Persona> obtenerTodasLasPersonas() {
        return personaService.obtenerTodasLasPersonas();
    }

    @ExceptionHandler(PersonaDuplicadaException.class)
    public ResponseEntity<String> handlePersonaDuplicada(PersonaDuplicadaException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
