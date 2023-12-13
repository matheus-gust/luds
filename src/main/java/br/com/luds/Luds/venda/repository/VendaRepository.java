package br.com.luds.Luds.venda.repository;

import br.com.luds.Luds.venda.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendaRepository extends JpaRepository<Venda, UUID> {

}
