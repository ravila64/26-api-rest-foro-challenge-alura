package com.api.challenge.foro.domain.topico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroTopico(
        @NotBlank
        String mensaje,
        @NotBlank
        String curso,
        @NotBlank
        String titulo
) {
}
