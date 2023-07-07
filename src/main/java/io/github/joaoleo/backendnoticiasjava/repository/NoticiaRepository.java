package io.github.joaoleo.backendnoticiasjava.repository;

import io.github.joaoleo.backendnoticiasjava.domain.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
}
