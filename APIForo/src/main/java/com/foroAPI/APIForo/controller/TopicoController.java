package com.foroAPI.APIForo.controller;

import com.foroAPI.APIForo.model.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<ObtenerTopico> registrarTopico(@RequestBody @Valid RegistrarTopico registrarTopico,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(registrarTopico));
        ObtenerTopico ObtenerTopico = new ObtenerTopico(topico.getId(),topico.getTitulo(),topico.getNombre_curso(),
                topico.getMensaje(), topico.getFechaCreacion());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(ObtenerTopico);
    }

    @GetMapping
    public ResponseEntity<Page<ListarTopico>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion) {
        var datos =  topicoRepository.findAll(paginacion).map(ListarTopico::new);
        return ResponseEntity.ok(datos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListarTopico> retornaDatosTopicos(@PathVariable Long id) {
        Topico datosTopicoTable = topicoRepository.getReferenceById(id);

        var datosTopico = new ListarTopico(
                datosTopicoTable.getId(),
                datosTopicoTable.getTitulo(),
                datosTopicoTable.getMensaje(),
                datosTopicoTable.getNombre_curso(),
                datosTopicoTable.getFechaCreacion()
        );

        return ResponseEntity.ok(datosTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional()
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid ActulizarTopico actulizarTopico){
        Topico topico = topicoRepository.getReferenceById(actulizarTopico.id());
        topico.actualizarTopico(actulizarTopico);
        return ResponseEntity.ok(new ObtenerTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getNombre_curso(),
                topico.getFechaCreacion()));

    }




}
