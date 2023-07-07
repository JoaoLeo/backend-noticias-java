package io.github.joaoleo.backendnoticiasjava.resources;

import io.github.joaoleo.backendnoticiasjava.domain.Categoria;
import io.github.joaoleo.backendnoticiasjava.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResorce {
    @Autowired
    private CategoriaService service;
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categorias= service.findAll();
        return ResponseEntity.ok().body(categorias);
    }

}