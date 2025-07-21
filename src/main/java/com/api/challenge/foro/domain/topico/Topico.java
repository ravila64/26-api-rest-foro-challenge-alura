package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.foro.Foro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String mensaje;
    private String curso;
    private String titulo;
    private Long usuario_id;
    private Boolean activo;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.activo = true;
        this.mensaje = datosRegistroTopico.mensaje();
        this.curso = datosRegistroTopico.curso();
        this.titulo = datosRegistroTopico.titulo();
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
        this.activo = false;
    }
}

