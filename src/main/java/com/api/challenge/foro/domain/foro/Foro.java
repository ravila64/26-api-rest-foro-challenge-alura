package com.api.challenge.foro.domain.foro;

import com.api.challenge.foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foros") // Asegura el nombre de la tabla
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Foro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100) // Reglas para la columna
    private String nombre;

    @OneToMany(mappedBy = "foro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topico> topicos = new ArrayList<>();

    // Constructor vacío obligatorio para JPA
    public Foro() {}

    // Constructor adicional si lo necesitas
    public Foro(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }

    // Opcional: agregar métodos utilitarios para agregar/quitar tópicos
//    public void agregarTopico(Topico topico) {
//        topicos.add(topico);
//        //topico.setForo(this);
//    }

//    public void eliminarTopico(Topico topico) {
//        topicos.remove(topico);
//        //topico.setForo(null);
//    }
}