package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.ValidacionException;
import com.api.challenge.foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
   @Autowired
   private TopicoRepository topicoRepository;
   @Autowired
   private UsuarioRepository usuarioRepository;

   public DatosRespuestaTopico topicoCreado(TopicoDTO topicoDTO){
      if (!usuarioRepository.findById(topicoDTO.autor_id()).isPresent()){
         throw new ValidacionException("ID de usuario no está registrado en la base de datos.");
      }
      var titulo= topicoDTO.titulo();
      if (titulo != null && topicoRepository.existsByTituloIgnoreCase(titulo)){
         throw new ValidacionException("Este título ya está existe en base de datos, Revisar topicos");
      }
      String mensaje = topicoDTO.mensaje();
      if (mensaje != null && topicoRepository.existsByMensajeIgnoreCase(mensaje)){
         throw new ValidacionException("Este mensaje ya está existe en base de datos. Revisar topicos" );
      }
      var usuario = usuarioRepository.findById(topicoDTO.autor_id()).get();
      var topicoNuevo= new Topico(null, titulo, mensaje, topicoDTO.fecha(),
                        topicoDTO.status(), usuario,topicoDTO.curso());
      topicoRepository.save(topicoNuevo);
      return new DatosRespuestaTopico(topicoNuevo);
   }

}
