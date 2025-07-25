package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
      Long id,
      String titulo,
      String mensaje,
      LocalDateTime fecha,
      Status status,
      Usuario autor,
      String curso
) {
   public DatosRespuestaTopico(Topico topico) {
      this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFecha(),
            topico.getStatus(),
            topico.getAutor(),
            topico.getCurso());
   }
}
