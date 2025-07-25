package com.api.challenge.foro.controller;

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

@RestController
@ResponseBody
@RequestMapping("/topicos")
//@SecurityRequirement(name = "bearer-key") no se maneja SWAGGER
public class TopicoController {
   @Autowired
   private TopicoRepository topicoRepository;
   @Autowired
   private UsuarioRepository usuarioRepository;


//   public ResponseEntity<DatosRespuestaTopico> registrarTopico(
//         @RequestBody @Valid DatosRegistroTopico datos,
//         UriComponentsBuilder uriComponentsBuilder) {
//      Topico topico = topicoRepository.save(new Topico(datos));
//      DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
//            topico.getFecha(), topico.getStatus(), topico.getAutor(), topico.getCurso());
//      URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
//      return ResponseEntity.created(url).body(datosRespuestaTopico);
//   }

   // registrar o insertar topicos
   @PostMapping
   @Transactional
   public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) {
      var topico = new Topico(datos);
      topicoRepository.save(topico);
      var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
      return ResponseEntity.created(uri).body(new DatosRespuestaTopico(topico));
   }

   // Listar topicos
   @GetMapping
   public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion) {
      return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
   }

   // Actualizar un topico
   @PutMapping
   @Transactional
   public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
      Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
      topico.actualizarDatos(datosActualizarTopico);
      return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
            topico.getFecha(), topico.getStatus(), topico.getAutor(), topico.getCurso()));
   }

   // Delete logico
   @DeleteMapping("/{id}")
   @Transactional
   public ResponseEntity eliminarTopico(@PathVariable Long id) {
      Topico topico = topicoRepository.getReferenceById(id);
      topico.desactivarTopico();
      return ResponseEntity.noContent().build();
   }

   // Muestra datos de un solo topico
   @GetMapping("/{id}")
   public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
      Topico topico = topicoRepository.getReferenceById(id);
      var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
            topico.getFecha(), topico.getStatus(), topico.getAutor(), topico.getCurso());
      return ResponseEntity.ok(datosTopico);
   }

}

