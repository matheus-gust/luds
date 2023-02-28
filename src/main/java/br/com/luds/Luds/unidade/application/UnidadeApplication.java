package br.com.luds.Luds.unidade.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.unidade.service.UnidadeService;
import br.com.luds.Luds.unidade.model.assembler.UnidadeAssembler;
import br.com.luds.Luds.unidade.model.dto.UnidadeDTO;
import br.com.luds.Luds.unidade.model.form.UnidadeForm;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UnidadeApplication {

    private final UnidadeService unidadeService;
    private final UnidadeAssembler unidadeAssembler;

    public ApiCollectionResponse<UnidadeDTO> listarUnidades(ApiPageRequest pageRequest) {
        Page pageUnidade = this.unidadeService.listarUnidades(pageRequest);
        return unidadeAssembler.assembleManyDTO(pageUnidade.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageUnidade.hasNext());
    }

    public UnidadeDTO buscarUnidadePorId(UUID id) {
        return this.unidadeAssembler.assembleDTO(this.unidadeService.buscarUnidadePorId(id));
    }

    public UnidadeDTO inserirUnidade(UnidadeForm unidade) {
        return this.unidadeAssembler.assembleDTO(this.unidadeService.inserirUnidade(this.unidadeAssembler.assembleEntity(unidade)));
    }

    public UnidadeDTO alterarUnidade(UUID id, UnidadeForm unidade) {
        return this.unidadeAssembler.assembleDTO(this.unidadeService.alterarUnidade(id, this.unidadeAssembler.assembleEntity(unidade)));
    }

    public void removerUnidade(UUID id) {
        this.unidadeService.removerUnidade(id);
    }
}
