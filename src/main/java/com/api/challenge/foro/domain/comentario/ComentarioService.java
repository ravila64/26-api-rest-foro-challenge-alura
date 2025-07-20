package com.api.challenge.foro.domain.comentario;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

   public String agregarComentario(Long topicoId) {
      return "Servicio: comentario agregado al tópico " + topicoId;
   }
}
