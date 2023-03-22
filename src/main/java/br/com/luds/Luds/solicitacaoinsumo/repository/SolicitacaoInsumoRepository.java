package br.com.luds.Luds.solicitacaoinsumo.repository;

import br.com.luds.Luds.solicitacaoinsumo.model.SolicitacaoInsumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SolicitacaoInsumoRepository extends JpaRepository<SolicitacaoInsumo, UUID> {

}
