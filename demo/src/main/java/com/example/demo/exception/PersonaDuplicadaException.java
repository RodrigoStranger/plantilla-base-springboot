package com.example.demo.exception;

public class PersonaDuplicadaException extends RuntimeException {
    public PersonaDuplicadaException(String mensaje) {
        super(mensaje);
    }
}

