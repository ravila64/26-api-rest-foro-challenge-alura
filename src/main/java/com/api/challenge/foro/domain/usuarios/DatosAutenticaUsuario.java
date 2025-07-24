package com.api.challenge.foro.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//UsuarioDTO
public record DatosAutenticaUsuario(
      @NotBlank
      String nombre,
      @NotBlank(message = "Utilizar correo electronico para usuario")
      @Email(message = "Correo Electronico no valido")
      String email,
      @NotBlank(message = "digite 4 a 15 caracteres")
      String clave)
{}
