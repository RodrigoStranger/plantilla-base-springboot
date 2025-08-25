package com.example.demo.controller;

import com.example.demo.service.IPersonaService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Persona;
import java.util.*;
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
    public ResponseEntity<Map<String, Object>> crearPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = personaService.crearPersona(persona);
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "Persona creada exitosamente.");
        body.put("codigo", HttpStatus.CREATED.value());
        body.put("dato", nuevaPersona);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        Persona personaActualizada = personaService.actualizarPersona(id, persona);
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "Persona actualizada exitosamente.");
        body.put("codigo", HttpStatus.OK.value());
        body.put("dato", personaActualizada);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerPersonaPorId(@PathVariable Long id) {
        Persona persona = personaService.obtenerPersonaPorId(id);
        Map<String, Object> body = new HashMap<>();
        if (persona != null) {
            body.put("mensaje", "Persona encontrada.");
            body.put("codigo", HttpStatus.OK.value());
            body.put("dato", persona);
            return ResponseEntity.status(HttpStatus.OK).body(body);
        } else {
            body.put("mensaje", "Persona no encontrada.");
            body.put("codigo", HttpStatus.NOT_FOUND.value());
            body.put("dato", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerTodasLasPersonas() {
        List<Persona> personas = personaService.obtenerTodasLasPersonas();
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "Listado de personas.");
        body.put("codigo", HttpStatus.OK.value());
        body.put("dato", personas);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersonaPorId(id);
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "Persona eliminada exitosamente.");
        body.put("codigo", HttpStatus.OK.value());
        body.put("dato", null);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @ExceptionHandler(PersonaDuplicadaException.class)
    public ResponseEntity<Map<String, Object>> handlePersonaDuplicada(PersonaDuplicadaException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", ex.getMessage());
        body.put("codigo", HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }
}
