package br.com.luds.Luds.formapagamento.repository;

import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, UUID> {
    @Query("SELECT u FROM FormaPagamento u ORDER BY u.nome ASC")
    Page<FormaPagamento> findAllOrderedByNomeAsc(Pageable pageable);
}
