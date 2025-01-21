package com.foroAPI.APIForo.model.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String nombre_curso;
    private String mensaje;
    private LocalDateTime fechaCreacion;



    public Topico(RegistrarTopico registrarTopico){
        this.titulo = registrarTopico.titulo();
        this.nombre_curso = registrarTopico.nombre_curso();
        this.mensaje = registrarTopico.mensaje();
        this.fechaCreacion = registrarTopico.fechaCreacion();
    }

    public Topico() {}

    public void actualizarTopico(ActulizarTopico actulizarTopico){
        if(actulizarTopico.titulo() != null){
            this.titulo = actulizarTopico.titulo();
        }
        if(actulizarTopico.nombre_curso() != null){
            this.nombre_curso = actulizarTopico.nombre_curso();
        }
        if(actulizarTopico.mensaje() != null){
            this.mensaje = actulizarTopico.mensaje();
        }

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}
