package com.api.challenge.foro.domain;

// se cambio Throwable por RuntimeException
public class ValidationException extends RuntimeException {
   public ValidationException(String mensaje) {
      super(mensaje);
   }
}
