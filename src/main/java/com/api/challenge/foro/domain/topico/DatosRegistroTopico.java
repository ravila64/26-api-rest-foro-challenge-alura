package com.api.challenge.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Long id, String title, String message, LocalDateTime date, Status status, Usuario usuario, String curso
public record DatosRegistroTopico(
        @NotBlank(message = "Titulo obligatorio")
        String titulo,
        @NotBlank(message = "Mensaje obligatorio")
        String mensaje,
        @NotBlank(message = "Curso obligatorio")
        String curso,
        @NotNull(message = "Colocar id usuario existente ")
        Long autor_id
) {
        public DatosRegistroTopico(String titulo, String mensaje, String curso, Long autor_id) {
                this.titulo = titulo;
                this.mensaje = mensaje;
                this.curso = curso;
                this.autor_id = autor_id;
        }
}
