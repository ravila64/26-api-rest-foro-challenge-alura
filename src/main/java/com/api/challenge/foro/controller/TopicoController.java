package com.api.challenge.foro.controller;

import com.api.challenge.foro.domain.topico.*;
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
@RequestMapping("/topicos")
//@SecurityRequirement(name = "bearer-key") no se maneja SWAGGER
public class TopicoController {
   @Autowired
   private TopicoRepository topicoRepository;

   // registrar o insertar topicos
   @PostMapping
   @Transactional
   public ResponseEntity<DatosRespuestaTopico> registrarTopico(
         @RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
         UriComponentsBuilder uriComponentsBuilder) {
      Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
      DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getMensaje(),
            topico.getCurso(), topico.getTitulo());
      URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
      return ResponseEntity.created(url).body(datosRespuestaTopico);
   }

   // Listar topicos
   @GetMapping
   public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion) {
//        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
      return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
   }

   // Actualizar un topico
   @PutMapping
   @Transactional
   public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
      Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
      topico.actualizarDatos(datosActualizarTopico);
      return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getMensaje(),
                  topico.getCurso(), topico.getTitulo()));
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
      var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getMensaje(),
      topico.getCurso(), topico.getTitulo());
      return ResponseEntity.ok(datosTopico);
   }

}

