package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.ValidacionException;
import com.api.challenge.foro.domain.usuario.Usuario;
import com.api.challenge.foro.domain.usuario.UsuarioRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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
   private LocalDateTime fecha;  // "yyyy-MM-ddTHH:mm"
   @Enumerated(EnumType.STRING)
   private Status status;
   @ManyToOne
   @JoinColumn(name = "autor_id")
   private Usuario autor;
   private String curso;
   private boolean activo;

   public Topico(DatosRegistroTopico datos) {
      this.id = null;
      this.titulo = datos.titulo();
      this.mensaje = datos.mensaje();
      this.fecha = LocalDateTime.now();
      this.status = datos.status();
      this.autor = datos.autor();
      this.curso = datos.curso();
      this.activo = true;
   }

   public Topico(Long id, String titulo, String mensaje,
                 LocalDateTime fecha, Status status, Usuario autor,
                 String curso)
   {
      this.id = id;
      this.titulo = titulo;
      this.mensaje = mensaje;
      this.fecha = fecha;
      this.status = status;
      this.autor = autor;
      this.curso = curso;
   }

   // actualizar datos
   public Topico actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

//      UsuarioRepository repository = null;

      var str = "";
      if (datosActualizarTopico.titulo() != null) {
         this.titulo = datosActualizarTopico.titulo();
         str = str + "Titulo ";
      }
      if (datosActualizarTopico.mensaje() != null) {
         this.mensaje = datosActualizarTopico.mensaje();
         str = str + "-Mensaje ";
      }
      if (datosActualizarTopico.fecha() != null) {
         this.fecha = datosActualizarTopico.fecha();
         str = str + "-Fecha ";
      }

      if (datosActualizarTopico.status() != null) {
         this.status = datosActualizarTopico.status();
         str = str + "-Status ";
      }

//      Long id = datosActualizarTopico.autor().getId();
//      if(id != null) {
//         this.autor = repository.findById(id).get();
//         str = str + "-Usuario ";
//      }

      if (datosActualizarTopico.curso() != null) {
         this.curso = datosActualizarTopico.curso();
         str = str + "-Curso ";
      }

      str = str + "Actualizado(s) ";
      throw new ValidacionException(str);

   }

   // desactivar topico
   public void desactivarTopico()
   {
      this.activo = false;
   }

   // activar topico
   public void activarTopico(){
      this.activo = true;
   }
}

