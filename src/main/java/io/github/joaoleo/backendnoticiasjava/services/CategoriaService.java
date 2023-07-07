package io.github.joaoleo.backendnoticiasjava.services;

import io.github.joaoleo.backendnoticiasjava.domain.Categoria;
import io.github.joaoleo.backendnoticiasjava.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria insert(Categoria Categoria){
        return repo.save(Categoria);
    }

    public List<Categoria> findAll(){
        return repo.findAll();
    }
}
