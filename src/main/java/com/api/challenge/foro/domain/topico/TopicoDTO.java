package com.api.challenge.foro.domain.topico;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record TopicoDTO(
      @NotNull(message = "No repetir El título.")
      String titulo,
      @NotNull(message = "Utilice un texto apropiado en el mensaje, no tan extenso.")
      String mensaje,
      @NotNull(message = "Seleccione uno de los Estados ´ACTIVO´, ´INACTIVO´ o 'RESUELTO'")
      Status status,
      @NotNull(message = "Utilice su ID de usuario_id  para autor.")
      Long usuario_Id,
      @NotNull(message = "Utilizar el curso relacionado con el topico.")
      String curso,
      LocalDateTime fecha
) {
}
