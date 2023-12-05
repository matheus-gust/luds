package br.com.luds.Luds.categoria.repository;

import br.com.luds.Luds.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

}
