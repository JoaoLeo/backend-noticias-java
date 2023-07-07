package io.github.joaoleo.backendnoticiasjava.services;

import io.github.joaoleo.backendnoticiasjava.domain.Noticia;
import io.github.joaoleo.backendnoticiasjava.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository repo;

    public Noticia insert(Noticia noticia){
        return repo.save(noticia);
    }

    public List<Noticia> findAll(){
        return repo.findAll();
    }

}
