package com.api.challenge.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Status status,
        String curso)
{}
