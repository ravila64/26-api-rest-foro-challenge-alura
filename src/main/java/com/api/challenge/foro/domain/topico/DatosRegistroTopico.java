package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

// Long id, String title, String message, LocalDateTime date, Status status, Usuario usuario, String curso
public record DatosRegistroTopico(
      @NotBlank(message = "{titulo.obl}")
      String titulo,
      @NotBlank(message = "{mensaje.obl}")
      String mensaje,
      @PastOrPresent(message = "{fecha.obli}")
      LocalDateTime fecha,
      @NotBlank(message = "{status.obl}")
      Status status,
      @NotNull(message = "{autor.obl}")
      @Valid
      Usuario autor,
      @NotBlank(message = "{curso.obl}")
      String curso,
      @NotNull(message = "{activo.obl}")
      Boolean activo
) {
}
