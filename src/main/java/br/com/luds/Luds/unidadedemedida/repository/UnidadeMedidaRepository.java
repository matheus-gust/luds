package br.com.luds.Luds.unidadedemedida.repository;

import br.com.luds.Luds.unidadedemedida.model.UnidadeMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, UUID> {
    @Query("SELECT u FROM UnidadeMedida u ORDER BY u.nome ASC")
    Page<UnidadeMedida> findAllOrderedByNomeAsc(Pageable pageable);
}
