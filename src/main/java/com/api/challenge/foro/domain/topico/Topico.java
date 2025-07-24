package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String titulo;
   private String mensaje;
   private LocalDateTime fecha;
   @Enumerated(EnumType.STRING)
   private Status status;
   @ManyToOne
   @JoinColumn(name = "autor_id")
   private Usuario autor;
   private String curso;
   private boolean activo;

   public Topico(DatosRegistroTopico datosRegistroTopico) {
      this.titulo = datosRegistroTopico.titulo();
      this.mensaje = datosRegistroTopico.mensaje();
      this.curso = datosRegistroTopico.curso();
      this.activo = true;
   }

   public Topico(Long id, String title, String message, LocalDateTime date, Status status, Usuario usuario, String curso) {
      this.id = id;
      this.titulo = title;
      this.mensaje = message;
      this.fecha = date;
      this.fecha = LocalDateTime.now();
      this.status = status;
      this.autor = usuario;
      this.curso = curso;
   }

   // actualizar datos
   public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
      if (datosActualizarTopico.titulo() != null) {
         this.titulo = datosActualizarTopico.titulo();
      }
      if (datosActualizarTopico.mensaje() != null) {
         this.mensaje = datosActualizarTopico.mensaje();
      }
      if (datosActualizarTopico.curso() != null) {
         this.curso = datosActualizarTopico.curso();
      }
      if (datosActualizarTopico.status() != null) {
         this.status = datosActualizarTopico.status();
      }
   }

   // desactivar topico
   public void desactivarTopico() {
      this.activo = false;
   }

}

