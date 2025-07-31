package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.ValidacionException;
import com.api.challenge.foro.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TopicoService {
   @Autowired
   private TopicoRepository topicoRepository;
   @Autowired
   private UsuarioRepository usuarioRepository;
   @Autowired
   private  Topico topico;

   public DatosRespuestaTopico topicoCreado(DatosRegistroTopico datosDTO){

      var usuario = usuarioRepository.findById(datosDTO.autor().getId())
            .orElseThrow(() -> new ValidacionException("ID de usuario no está registrado en la base de datos."));

      var titulo= datosDTO.titulo().trim();
      if (!titulo.isBlank() && topicoRepository.existsByTituloIgnoreCase(titulo)) {
         throw new ValidacionException("Este título ya está existe en base de datos, Revisar topicos");
      }

      String mensaje = datosDTO.mensaje().trim();
      if (!mensaje.isBlank() && topicoRepository.existsByMensajeIgnoreCase(mensaje)){
         throw new ValidacionException("Este mensaje ya está existe en base de datos. Revisar topicos" );
      }

      var topicoNuevo= new Topico(null, titulo, mensaje, datosDTO.fecha(),
                        datosDTO.status(), usuario, datosDTO.curso(), true);
      topicoRepository.save(topicoNuevo);
      return new DatosRespuestaTopico(topicoNuevo);
   }

   // Actualizar topico
   @Transactional
   public DatosRespuestaTopico actualizarTopico(DatosActualizarTopico datosDTO) {
     Topico topicoActualizado = topico.actualizarDatos(datosDTO);
     return new DatosRespuestaTopico(topicoActualizado);
   }
}
