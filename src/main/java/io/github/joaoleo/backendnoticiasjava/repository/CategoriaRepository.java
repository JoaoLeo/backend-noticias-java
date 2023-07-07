package io.github.joaoleo.backendnoticiasjava.repository;

import io.github.joaoleo.backendnoticiasjava.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
