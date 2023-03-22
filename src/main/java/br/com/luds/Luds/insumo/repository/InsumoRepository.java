package br.com.luds.Luds.insumo.repository;

import br.com.luds.Luds.insumo.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsumoRepository extends JpaRepository<Insumo, UUID> {

}
