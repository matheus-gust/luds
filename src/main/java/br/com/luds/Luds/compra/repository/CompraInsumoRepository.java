package br.com.luds.Luds.compra.repository;

import br.com.luds.Luds.compra.model.CompraInsumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CompraInsumoRepository extends JpaRepository<CompraInsumo, UUID> {

    List<CompraInsumo> findAllByCompraId(UUID id);
}
