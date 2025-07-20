package com.api.challenge.foro.domain.foro;

import org.springframework.stereotype.Service;

@Service
public class ForoService {

   public String listarForos() {
      return "Servicio: lista de foros";
   }

   public String crearForo() {
      return "Servicio: foro creado";
   }
}