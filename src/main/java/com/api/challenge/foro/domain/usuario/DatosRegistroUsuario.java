package com.api.challenge.foro.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroUsuario(
      Long id,
      @NotBlank
      String nombre,
      @NotBlank(message = "Usar email para nombre de usuario")
      @Email
      String email,
      @NotBlank(message = "Debe tener entre 6 y 10 digitos.") @Pattern(regexp = "\\d{6,10}")
      String clave
) {
//   public Long getId() {
//      return id;
//   }
//   public String getNombre() {
//      return nombre;
//   }
//   public String getEmail() { return email; }
}
