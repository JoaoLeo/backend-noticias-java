package io.github.joaoleo.backendnoticiasjava.resources;

import io.github.joaoleo.backendnoticiasjava.domain.Noticia;
import io.github.joaoleo.backendnoticiasjava.services.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/noticias")
public class NoticiaResorce {
    @Autowired
    private NoticiaService service;
    @GetMapping
    public ResponseEntity<List<Noticia>> findAll(){
        List<Noticia> noticias = service.findAll();
        return ResponseEntity.ok().body(noticias);
    }
}
