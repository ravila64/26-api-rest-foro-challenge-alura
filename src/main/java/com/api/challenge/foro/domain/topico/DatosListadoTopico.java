package com.api.challenge.foro.domain.topico;


import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String curso, LocalDateTime fecha){
   public DatosListadoTopico(Topico topico){
      this(topico.getId(), topico.getTitulo(),topico.getMensaje(), topico.getCurso(), topico.getFecha());
   }
}