package com.api.challenge.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Status status,
        @NotNull Long autor_id,
        String curso) {
}
