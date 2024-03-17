package br.com.luds.Luds.compra.repository;

import br.com.luds.Luds.compra.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompraRepository extends JpaRepository<Compra, UUID> {

}
