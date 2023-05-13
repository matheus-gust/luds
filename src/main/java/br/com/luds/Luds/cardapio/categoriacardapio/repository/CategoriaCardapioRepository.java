package br.com.luds.Luds.cardapio.categoriacardapio.repository;

import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaCardapioRepository extends JpaRepository<CategoriaCardapio, UUID> {

}
