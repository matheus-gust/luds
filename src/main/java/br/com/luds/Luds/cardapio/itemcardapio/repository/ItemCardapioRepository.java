package br.com.luds.Luds.cardapio.itemcardapio.repository;

import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, UUID> {

}
