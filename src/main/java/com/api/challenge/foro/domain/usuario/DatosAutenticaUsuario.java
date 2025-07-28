package com.api.challenge.foro.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//UsuarioDTO
public record DatosAutenticaUsuario(
      @NotBlank
      @Email(message = "Correo Electronico Invalido")
      String email,
      @NotBlank
      String clave)
{}
