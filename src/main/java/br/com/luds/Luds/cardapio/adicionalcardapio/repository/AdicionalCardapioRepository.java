package br.com.luds.Luds.cardapio.adicionalcardapio.repository;

import br.com.luds.Luds.cardapio.adicionalcardapio.model.AdicionalCardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdicionalCardapioRepository extends JpaRepository<AdicionalCardapio, UUID> {

}
