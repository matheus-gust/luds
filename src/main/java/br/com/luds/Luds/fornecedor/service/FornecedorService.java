package br.com.luds.Luds.fornecedor.service;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.fornecedor.exception.FornecedorNaoEncontradaException;
import br.com.luds.Luds.fornecedor.model.Fornecedor;
import br.com.luds.Luds.fornecedor.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FornecedorService {

    private final FornecedorRepository insumoRepository;

    public Fornecedor buscarFornecedorPorId(UUID id) {
        if(Objects.isNull(id)) {
            throw new FornecedorNaoEncontradaException();
        }
        return this.insumoRepository.findById(id).orElseThrow(() -> new FornecedorNaoEncontradaException());
    }

    public Page<Fornecedor> listarFornecedors(ApiPageRequest pageRequest) {
        return this.insumoRepository.findAll(pageRequest.setPage());
    }

    public Fornecedor inserirFornecedor(Fornecedor insumo) {
        return this.insumoRepository.save(insumo);
    }

    public Fornecedor alterarFornecedor(UUID id, Fornecedor insumo) {
        Fornecedor insumoFornecedorAtualizade = this.buscarFornecedorPorId(id);
        insumoFornecedorAtualizade.atualiza(insumo);
        return this.insumoRepository.save(insumoFornecedorAtualizade);
    }

    public void removerFornecedor(UUID id) {
        Fornecedor insumo = this.buscarFornecedorPorId(id);
        this.insumoRepository.delete(insumo);
    }
}
