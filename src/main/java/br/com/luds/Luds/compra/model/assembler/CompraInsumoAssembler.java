package br.com.luds.Luds.compra.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.compra.model.CompraInsumo;
import br.com.luds.Luds.compra.model.dto.CompraInsumoDTO;
import br.com.luds.Luds.compra.model.form.CompraInsumoIn;
import br.com.luds.Luds.insumo.model.Insumo;
import br.com.luds.Luds.insumo.model.assembler.InsumoAssembler;
import br.com.luds.Luds.insumo.model.dto.InsumoDTO;
import br.com.luds.Luds.insumo.service.InsumoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompraInsumoAssembler implements ILudzAssembler<CompraInsumo, CompraInsumoDTO, CompraInsumoIn> {

    private final InsumoAssembler insumoAssembler;
    private final InsumoService insumoService;
    @Override
    public CompraInsumoDTO assembleDTO(CompraInsumo entity) {
        InsumoDTO insumo = insumoAssembler.assembleDTO(entity.getInsumo());
        return new CompraInsumoDTO(entity.getId(), null, insumo, entity.getQuantidade(), entity.getValor());
    }

    @Override
    public CompraInsumo assembleEntity(CompraInsumoIn vendaItemCardapioIn) {
        Insumo insumo = this.insumoService.buscarInsumoPorId(vendaItemCardapioIn.getInsumo().getId());
        return new CompraInsumo(null, null, insumo, vendaItemCardapioIn.getQuantidade(), vendaItemCardapioIn.getValor());
    }
}
