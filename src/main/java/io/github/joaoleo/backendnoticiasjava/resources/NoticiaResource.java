package io.github.joaoleo.backendnoticiasjava.resources;

import io.github.joaoleo.backendnoticiasjava.domain.Noticia;
import io.github.joaoleo.backendnoticiasjava.services.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/noticias")
public class NoticiaResource {

    @Autowired
    private NoticiaService service;
    @GetMapping
    public ResponseEntity<List<Noticia>> findAll(){
        List<Noticia> noticias = service.findAll();
        return ResponseEntity.ok().body(noticias);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Noticia> findById(@PathVariable Long id) {
        Noticia obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Noticia> insert(@RequestBody Noticia obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Noticia> update(@PathVariable Long id,  @RequestBody Noticia obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}
