package com.api.challenge.foro.domain;

// se cambio Throwable por RuntimeException
public class ValidacionException extends RuntimeException {
   public ValidacionException(String mensaje) {
      super(mensaje);
   }
}
