package com.foroAPI.APIForo.model.topico;

import java.time.LocalDateTime;
//Get obtener
public record ListarTopico(Long id, String titulo, String nombre_curso, String mensaje, LocalDateTime fechaCreacion) {

    public ListarTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(), topico.getNombre_curso(),topico.getMensaje(), topico.getFechaCreacion());
    }
}
