package br.com.luds.Luds.solicitacaoinsumo.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.solicitacaoinsumo.model.assembler.SolicitacaoInsumoAssembler;
import br.com.luds.Luds.solicitacaoinsumo.model.dto.SolicitacaoInsumoDTO;
import br.com.luds.Luds.solicitacaoinsumo.model.form.SolicitacaoInsumoForm;
import br.com.luds.Luds.solicitacaoinsumo.service.SolicitacaoInsumoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SolicitacaoInsumoApplication {

    private final SolicitacaoInsumoService solicitacaoInsumoService;
    private final SolicitacaoInsumoAssembler solicitacaoInsumoAssembler;

    public ApiCollectionResponse<SolicitacaoInsumoDTO> listarSolicitacaoInsumos(ApiPageRequest pageRequest) {
        Page pageSolicitacaoInsumo = this.solicitacaoInsumoService.listarSolicitacaoInsumos(pageRequest);
        return solicitacaoInsumoAssembler.assembleManyDTO(pageSolicitacaoInsumo.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageSolicitacaoInsumo.hasNext());
    }

    public SolicitacaoInsumoDTO buscarSolicitacaoInsumoPorId(UUID id) {
        return this.solicitacaoInsumoAssembler.assembleDTO(this.solicitacaoInsumoService.buscarSolicitacaoInsumoPorId(id));
    }

    public SolicitacaoInsumoDTO inserirSolicitacaoInsumo(SolicitacaoInsumoForm solicitacaoInsumo) {
        return this.solicitacaoInsumoAssembler.assembleDTO(this.solicitacaoInsumoService.inserirSolicitacaoInsumo(this.solicitacaoInsumoAssembler.assembleEntity(solicitacaoInsumo)));
    }

    public SolicitacaoInsumoDTO alterarSolicitacaoInsumo(UUID id, SolicitacaoInsumoForm solicitacaoInsumo) {
        return this.solicitacaoInsumoAssembler.assembleDTO(this.solicitacaoInsumoService.alterarSolicitacaoInsumo(id, this.solicitacaoInsumoAssembler.assembleEntity(solicitacaoInsumo)));
    }

    public void removerSolicitacaoInsumo(UUID id) {
        this.solicitacaoInsumoService.removerSolicitacaoInsumo(id);
    }
}
