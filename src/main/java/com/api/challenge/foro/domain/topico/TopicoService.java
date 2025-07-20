package com.api.challenge.foro.domain.topico;

import org.springframework.stereotype.Service;

@Service
public class TopicoService {

   public String listarTopicos() {
      return "Servicio: lista de tópicos";
   }

   public String crearTopico() {
      return "Servicio: tópico creado";
   }

   public String verTopico(Long id) {
      return "Servicio: detalles del tópico " + id;
   }
}
