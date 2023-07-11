package io.github.joaoleo.backendnoticiasjava.services;

import io.github.joaoleo.backendnoticiasjava.domain.Noticia;
import io.github.joaoleo.backendnoticiasjava.repository.NoticiaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository repo;

    public Noticia insert(Noticia Noticia){
        return repo.save(Noticia);
    }

    public List<Noticia> findAll(){
        return repo.findAll();
    }

    public Noticia findById(Long id){
        Optional<Noticia> obj = repo.findById(id);
        return obj.orElseThrow(() ->
                new ObjetoNaoEncontrado("Objeto não encotrado na base de dados")
        );
    }
    public Noticia update(Long id, Noticia novaNoticia){
        try {
            Noticia obj = repo.getReferenceById(id);
            obj.setTitulo(novaNoticia.getTitulo());
            obj.setDescricao(novaNoticia.getDescricao());
            obj.setCategoria(novaNoticia.getCategoria());
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
