package com.foroAPI.APIForo.model.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ObtenerTopico(@NotNull Long id, String titulo, String nombre_curso, String mensaje, LocalDateTime fechaCreacion ) {
}
