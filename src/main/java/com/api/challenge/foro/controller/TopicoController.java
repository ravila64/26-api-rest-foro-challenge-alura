package com.api.challenge.foro.controller;

import com.api.challenge.foro.domain.ValidacionException;
import com.api.challenge.foro.domain.topico.*;
import com.api.challenge.foro.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@ResponseBody
@RequestMapping("/topicos")
//@SecurityRequirement(name = "bearer-key") no se maneja SWAGGER
public class TopicoController {
   @Autowired
   private TopicoRepository topicoRepository;
   @Autowired
   private UsuarioRepository usuarioRepository;
   @Autowired
   private TopicoService topicoService;

   @PostMapping
   public ResponseEntity<DatosRespuestaTopico> crearTopico(@RequestBody DatosRegistroTopico datosDTO) {
      DatosRespuestaTopico respuesta = topicoService.topicoCreado(datosDTO);
      return ResponseEntity.ok(respuesta);
   }

   // Listar topicos
   @GetMapping
   public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 10) Pageable paginacion) {
      return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
   }

   @PutMapping("/{id}")
   @Transactional
   public ResponseEntity actualizarTopico(@PathVariable long id, @RequestBody DatosActualizarTopico actualiza) {
      var topico = topicoRepository.getReferenceById(id);
      DatosRespuestaTopico respuesta = topicoService.actualizarTopico(actualiza);
      return ResponseEntity.ok(respuesta);
   }

   // Delete logico
   @DeleteMapping("/{id}")
   @Transactional
   public ResponseEntity eliminarTopico(@PathVariable Long id) {
      Topico topico = topicoRepository.getReferenceById(id);
      topico.desactivarTopico();
      return ResponseEntity.ok("Registro Eliminado");    //.noContent().build();
   }

   // Recuperar un topico
   @PutMapping("/recupera/{id}")
   @Transactional
   public ResponseEntity recuperar(@PathVariable Long id) {
      var topico = topicoRepository.getReferenceById(id);
      topico.activarTopico();
      return ResponseEntity.ok("Registro Recuperado");
   }

   // Muestra datos de un solo topico
   @GetMapping("/{id}")
   public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
      Optional<Topico> topico = topicoRepository.findById(id);
      if (!topico.isEmpty()) {
         throw new ValidacionException("Este id="+id+" de topico no existe !!!");
      }
      var datos = topico.get();
      var datosTopico = new DatosRespuestaTopico(datos.getId(), datos.getTitulo(), datos.getMensaje(),
            datos.getFecha(), datos.getStatus(), datos.getAutor().getId(), datos.getCurso(), true);
      return ResponseEntity.ok(datosTopico);
   }

}

