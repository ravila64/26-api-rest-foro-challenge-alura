package com.api.challenge.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank
        String mensaje,
        @NotBlank
        String curso,
        @NotBlank
        String titulo
) {
}
