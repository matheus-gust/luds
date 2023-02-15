package br.com.luds.Luds.unidade.repository;

import br.com.luds.Luds.unidade.model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UnidadeRepository extends JpaRepository<Unidade, UUID> {

}
