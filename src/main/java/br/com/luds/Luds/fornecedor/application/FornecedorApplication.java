package br.com.luds.Luds.fornecedor.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.fornecedor.model.assembler.FornecedorAssembler;
import br.com.luds.Luds.fornecedor.model.dto.FornecedorDTO;
import br.com.luds.Luds.fornecedor.model.form.FornecedorForm;
import br.com.luds.Luds.fornecedor.service.FornecedorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FornecedorApplication {

    private final FornecedorService fornecedorService;
    private final FornecedorAssembler fornecedorAssembler;

    public ApiCollectionResponse<FornecedorDTO> listarFornecedors(ApiPageRequest pageRequest) {
        Page pageFornecedor = this.fornecedorService.listarFornecedors(pageRequest);
        return fornecedorAssembler.assembleManyDTO(pageFornecedor.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageFornecedor.hasNext());
    }

    public FornecedorDTO buscarFornecedorPorId(UUID id) {
        return this.fornecedorAssembler.assembleDTO(this.fornecedorService.buscarFornecedorPorId(id));
    }

    public FornecedorDTO inserirFornecedor(FornecedorForm fornecedor) {
        return this.fornecedorAssembler.assembleDTO(this.fornecedorService.inserirFornecedor(this.fornecedorAssembler.assembleEntity(fornecedor)));
    }

    public FornecedorDTO alterarFornecedor(UUID id, FornecedorForm fornecedor) {
        return this.fornecedorAssembler.assembleDTO(this.fornecedorService.alterarFornecedor(id, this.fornecedorAssembler.assembleEntity(fornecedor)));
    }

    public void removerFornecedor(UUID id) {
        this.fornecedorService.removerFornecedor(id);
    }
}
