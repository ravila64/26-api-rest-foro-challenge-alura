package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

// Long id, String title, String message, LocalDateTime date, Status status, Usuario usuario, String curso
public record DatosRegistroTopico(
      @NotBlank(message = "{titulo.obl}")
      String titulo,
      @NotBlank(message = "{mensaje.obl}")
      String mensaje,
      @NotBlank(message = "{fecha.obl}")
      LocalDateTime fecha,
      @NotNull(message = "{status.obl}")
      Status status,
      @NotBlank(message = "{curso.obl}")
      String curso,
      @NotNull(message = "{autor.obl}")
      Usuario autor,
      @NotBlank(message = "{activo.obl}")
      Boolean activo
) {
}
