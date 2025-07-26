package com.api.challenge.foro.domain.topico;


import java.time.LocalDateTime;

public record DatosListadoTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 LocalDateTime fecha,
                                 Status status,
                                 Long autor_id,
                                 String curso){
   public DatosListadoTopico(Topico topico){
      this(topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFecha(),
            topico.getStatus(),
            topico.getAutor().getId(),
            topico.getCurso());
   }
}