package com.foroAPI.APIForo.model.topico;

import jakarta.validation.constraints.NotNull;

public record ActulizarTopico(@NotNull Long id, String titulo, String nombre_curso, String mensaje ) {
}
