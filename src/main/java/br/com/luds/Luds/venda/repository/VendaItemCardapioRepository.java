package br.com.luds.Luds.venda.repository;

import br.com.luds.Luds.venda.model.VendaItemCardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VendaItemCardapioRepository extends JpaRepository<VendaItemCardapio, UUID> {

    List<VendaItemCardapio> findAllByVendaId(UUID id);
}
