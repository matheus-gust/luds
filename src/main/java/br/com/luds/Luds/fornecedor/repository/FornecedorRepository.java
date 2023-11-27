package br.com.luds.Luds.fornecedor.repository;

import br.com.luds.Luds.fornecedor.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {

}
