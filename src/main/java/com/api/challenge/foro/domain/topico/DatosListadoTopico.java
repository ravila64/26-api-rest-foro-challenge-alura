package com.api.challenge.foro.domain.topico;


public record DatosListadoTopico(Long id, String mensaje, String curso, String titulo){
   public DatosListadoTopico(Topico topico){
      this(topico.getId(),topico.getMensaje(), topico.getCurso(), topico.getTitulo());
   }
}