package br.com.luds.Luds.cliente.repository;

import br.com.luds.Luds.cliente.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    @Query("SELECT u FROM Cliente u ORDER BY u.nome ASC")
    Page<Cliente> findAllOrderedByNomeAsc(Pageable pageable);
}
