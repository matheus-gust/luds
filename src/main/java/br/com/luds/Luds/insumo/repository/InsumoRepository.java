package br.com.luds.Luds.insumo.repository;

import br.com.luds.Luds.insumo.model.Insumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface InsumoRepository extends JpaRepository<Insumo, UUID> {
    @Query("SELECT u FROM Insumo u ORDER BY u.codigo ASC")
    Page<Insumo> findAllOrderedByCodigoAsc(Pageable pageable);
}
