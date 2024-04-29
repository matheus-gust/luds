package br.com.luds.Luds.tipopagamento.repository;

import br.com.luds.Luds.tipopagamento.model.TipoPagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, UUID> {
    @Query("SELECT u FROM TipoPagamento u ORDER BY u.nome ASC")
    Page<TipoPagamento> findAllOrderedByNomeAsc(Pageable pageable);
}
