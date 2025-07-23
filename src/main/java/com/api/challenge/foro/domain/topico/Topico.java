package com.api.challenge.foro.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
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
    private String curso;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario usuario;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.status = true;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.curso = datosRegistroTopico.curso();
    }

    // actualizar datos
public void actualizarDatos(DatosActualizarTopico datosActualizarTopico){
    if(datosActualizarTopico.mensaje()!=null){
        this.mensaje =datosActualizarTopico.mensaje();
    }
    if(datosActualizarTopico.curso()!=null) {
        this.curso = datosActualizarTopico.curso();
    }
    if(datosActualizarTopico.titulo()!=null) {
        this.titulo = datosActualizarTopico.titulo();
    }
}
    // desactivar topico
    public void desactivarTopico() {
        this.status = false;
    }
}

