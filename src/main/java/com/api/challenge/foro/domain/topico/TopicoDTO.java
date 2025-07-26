package com.api.challenge.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record TopicoDTO(
      @NotNull(message = "No repetir El título.")
      String titulo,
      @NotNull(message = "Utilice un texto apropiado en el mensaje, no tan extenso.")
      String mensaje,
      @NotNull(message = "{fecha.obl}")
      LocalDateTime fecha,
      @NotNull(message = "Seleccione uno de los Estados ´ACTIVO´, ´INACTIVO´ o 'RESUELTO'")
      Status status,
      @NotNull(message = "Utilice su ID de usuario_id  para autor.")
      Long autor_id,
      @NotNull(message = "Utilizar el curso relacionado con el topico.")
      String curso,
      @NotBlank
      Boolean activo
) {
}
