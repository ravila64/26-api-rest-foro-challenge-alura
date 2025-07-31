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
   public Topico actualizarTopico(Long id, DatosActualizarTopico datos) {
      Topico topico = topicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

      if (datos.titulo()!=null && !datos.titulo().isBlank()) topico.setTitulo(datos.titulo());
      if (datos.mensaje() != null && !datos.mensaje().isBlank()) topico.setMensaje(datos.mensaje());
      if (datos.fecha() != null) topico.setFecha(datos.fecha());
      if (datos.status() != null) topico.setStatus(datos.status());
      if (datos.curso() != null) topico.setCurso(datos.curso());

      return topicoRepository.save(topico);
   }

//   @Transactional
//   public DatosRespuestaTopico actualizarTopico(DatosActualizarTopico datosDTO) {
//     Topico topicoActualizado = topico.actualizarDatos(datosDTO);
//     return new DatosRespuestaTopico(topicoActualizado);
//   }
}
