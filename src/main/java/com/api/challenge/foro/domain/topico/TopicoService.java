package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.ValidacionException;
import com.api.challenge.foro.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class TopicoService {
   @Autowired
   private TopicoRepository topicoRepository;
   @Autowired
   private UsuarioRepository usuarioRepository;

   public DatosRespuestaTopico topicoCreado(DatosRegistroTopico datosDTO){
      //Optional isAutorId =usuarioRepository.findById(datosDTO.autor().getId());

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
      //var usuario = usuarioRepository.findById(datosDTO.autor().getId()).get();
      var topicoNuevo= new Topico(null, titulo, mensaje, datosDTO.fecha(),
                        datosDTO.status(), usuario, datosDTO.curso(), true);
      topicoRepository.save(topicoNuevo);
      return new DatosRespuestaTopico(topicoNuevo);
   }

   // Actualizar topico
   @Transactional
   // DatosRespuestaTopico actualizarTopico(DatosActualizarTopico datos)
   public Topico actualizarTopico(Topico datos) {
          //datos.actualizarDatos(DatosActualizarTopico datos);   // estaba topico
   return datos;
//      return new DatosRespuestaTopico(
//            datos.getId(),
//            datos.getTitulo(),
//            datos.getMensaje(),
//            datos.getFecha(),
//            datos.getStatus(),
//            datos.getAutor().getId(),
//            datos.getCurso(),
//            datos.isActivo()
//      );
   }
}
