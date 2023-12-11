package br.com.luds.Luds.cardapio.itemcardapio.repository;

import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemCardapioVariacaoRepository extends JpaRepository<ItemCardapioVariacao, UUID> {

    List<ItemCardapioVariacao> findAllByVariacaoCardapioIn(List<UUID> variacoes);
}
