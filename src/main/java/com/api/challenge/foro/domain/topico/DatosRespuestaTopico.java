package com.api.challenge.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
      Long id,
      String titulo,
      String mensaje,
      Status status,
      Long autor_id,
      String curso,
      LocalDateTime fecha
) {
   public DatosRespuestaTopico(Topico topico) {
      this(topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getStatus(),
            topico.getAutor().getId(),
            topico.getCurso(),
            topico.getFecha());
   }
}
