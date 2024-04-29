package br.com.luds.Luds.venda.repository;

import br.com.luds.Luds.venda.model.Parte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParteRepository extends JpaRepository<Parte, UUID> {

    List<Parte> findAllByVendaId(UUID id);
}
