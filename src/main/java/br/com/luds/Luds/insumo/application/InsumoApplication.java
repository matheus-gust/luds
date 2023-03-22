package br.com.luds.Luds.insumo.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.insumo.model.assembler.InsumoAssembler;
import br.com.luds.Luds.insumo.model.dto.InsumoDTO;
import br.com.luds.Luds.insumo.model.form.InsumoForm;
import br.com.luds.Luds.insumo.service.InsumoService;
import br.com.luds.Luds.unidade.model.dto.UnidadeDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class InsumoApplication {

    private final InsumoService insumoService;
    private final InsumoAssembler insumoAssembler;

    public ApiCollectionResponse<InsumoDTO> listarInsumos(ApiPageRequest pageRequest) {
        Page pageInsumo = this.insumoService.listarInsumos(pageRequest);
        return insumoAssembler.assembleManyDTO(pageInsumo.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageInsumo.hasNext());
    }

    public InsumoDTO buscarInsumoPorId(UUID id) {
        return this.insumoAssembler.assembleDTO(this.insumoService.buscarInsumoPorId(id));
    }

    public InsumoDTO inserirInsumo(InsumoForm insumo) {
        return this.insumoAssembler.assembleDTO(this.insumoService.inserirInsumo(this.insumoAssembler.assembleEntity(insumo)));
    }

    public InsumoDTO alterarInsumo(UUID id, InsumoForm insumo) {
        return this.insumoAssembler.assembleDTO(this.insumoService.alterarInsumo(id, this.insumoAssembler.assembleEntity(insumo)));
    }

    public void removerInsumo(UUID id) {
        this.insumoService.removerInsumo(id);
    }
}
