package com.api.challenge.foro.domain.topico;

import com.api.challenge.foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DatosActualizarTopico(
        @NotNull Long id,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull LocalDateTime fecha,
        @NotBlank Status status,
        @NotNull Long autor_id,
        @NotBlank String curso) {
}
