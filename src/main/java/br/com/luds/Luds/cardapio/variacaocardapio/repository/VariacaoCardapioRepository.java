package br.com.luds.Luds.cardapio.variacaocardapio.repository;

import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VariacaoCardapioRepository extends JpaRepository<VariacaoCardapio, UUID> {

}
