package com.password.demo.excepciones;

public class ExcepcionPersonalizadaNoEncontrado extends RuntimeException{
    public ExcepcionPersonalizadaNoEncontrado(String message) {
        super(message);
    }
}
