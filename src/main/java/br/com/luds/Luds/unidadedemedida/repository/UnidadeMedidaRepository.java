package br.com.luds.Luds.unidadedemedida.repository;

import br.com.luds.Luds.unidadedemedida.model.UnidadeMedida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, UUID> {

}
