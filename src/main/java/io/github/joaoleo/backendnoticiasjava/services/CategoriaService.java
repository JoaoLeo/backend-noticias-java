package io.github.joaoleo.backendnoticiasjava.services;

import io.github.joaoleo.backendnoticiasjava.domain.Categoria;
import io.github.joaoleo.backendnoticiasjava.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria insert(Categoria categoria){
        return repo.save(categoria);
    }

    public List<Categoria> findAll(){
        return repo.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() ->
            new ObjetoNaoEncontrado("Objeto não encotrado na base de dados")
        );
    }
    public Categoria update(Long id, Categoria novaCategoria){
        try {
            Categoria obj = repo.getReferenceById(id);
            obj.setNome(novaCategoria.getNome());
            return repo.save(obj);
        } catch (EntityNotFoundException e){
            throw new ObjetoNaoEncontrado(e.getMessage());
        }
    }
    public void delete(Long id){
        try {
            if(repo.existsById(id))
                repo.deleteById(id);
            else
                throw new ObjetoNaoEncontrado("Objeto não encontrado");

        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }
}
