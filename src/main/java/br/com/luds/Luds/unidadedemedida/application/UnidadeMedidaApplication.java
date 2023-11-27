package br.com.luds.Luds.unidadedemedida.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.unidadedemedida.model.assembler.UnidadeMedidaAssembler;
import br.com.luds.Luds.unidadedemedida.model.dto.UnidadeMedidaDTO;
import br.com.luds.Luds.unidadedemedida.model.form.UnidadeMedidaForm;
import br.com.luds.Luds.unidadedemedida.service.UnidadeMedidaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UnidadeMedidaApplication {

    private final UnidadeMedidaService unidadeMedidaService;
    private final UnidadeMedidaAssembler unidadeMedidaAssembler;

    public ApiCollectionResponse<UnidadeMedidaDTO> listarUnidadeMedidas(ApiPageRequest pageRequest) {
        Page pageUnidadeMedida = this.unidadeMedidaService.listarUnidadeMedidas(pageRequest);
        return unidadeMedidaAssembler.assembleManyDTO(pageUnidadeMedida.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageUnidadeMedida.hasNext());
    }

    public UnidadeMedidaDTO buscarUnidadeMedidaPorId(UUID id) {
        return this.unidadeMedidaAssembler.assembleDTO(this.unidadeMedidaService.buscarUnidadeMedidaPorId(id));
    }

    public UnidadeMedidaDTO inserirUnidadeMedida(UnidadeMedidaForm unidadeMedida) {
        return this.unidadeMedidaAssembler.assembleDTO(this.unidadeMedidaService.inserirUnidadeMedida(this.unidadeMedidaAssembler.assembleEntity(unidadeMedida)));
    }

    public UnidadeMedidaDTO alterarUnidadeMedida(UUID id, UnidadeMedidaForm unidadeMedida) {
        return this.unidadeMedidaAssembler.assembleDTO(this.unidadeMedidaService.alterarUnidadeMedida(id, this.unidadeMedidaAssembler.assembleEntity(unidadeMedida)));
    }

    public void removerUnidadeMedida(UUID id) {
        this.unidadeMedidaService.removerUnidadeMedida(id);
    }
}
