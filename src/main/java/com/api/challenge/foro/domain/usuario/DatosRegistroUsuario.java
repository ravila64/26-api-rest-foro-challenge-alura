package com.api.challenge.foro.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroUsuario(
      Long id,
      @NotBlank
      String nombre,
      @NotBlank(message = "Usar email para nombre de usuario")
      @Email(message = "Email invalido")
      String email,
      @NotBlank(message = "Clave de 4 a 10 digitos.") @Pattern(regexp = "\\d{4,10}")
      @NotBlank
      String clave,
      @NotNull
      Boolean activo
) {
}
