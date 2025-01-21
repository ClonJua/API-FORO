package com.foroAPI.APIForo.model.topico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

//PUT agregar
public record RegistrarTopico(

        @NotBlank
         String titulo,
         @NotBlank
         String nombre_curso,
         @NotBlank
         String mensaje,
         @NotNull @Future
         LocalDateTime fechaCreacion) {
    
}
