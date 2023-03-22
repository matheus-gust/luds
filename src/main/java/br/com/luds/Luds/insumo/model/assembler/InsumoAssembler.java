package br.com.luds.Luds.insumo.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.insumo.model.Insumo;
import br.com.luds.Luds.insumo.model.dto.InsumoDTO;
import br.com.luds.Luds.insumo.model.form.InsumoForm;
import org.springframework.stereotype.Component;

@Component
public class InsumoAssembler implements ILudzAssembler<Insumo, InsumoDTO, InsumoForm> {
    @Override
    public InsumoDTO assembleDTO(Insumo entity) {
        return new InsumoDTO(entity.getId(), entity.getCodigo(), entity.getNome(), entity.getFornecedor(), entity.getCustoCompra(), entity.getValorVenda(), entity.getUnidadeMedida());
    }

    @Override
    public Insumo assembleEntity(InsumoForm insumoForm) {
        return new Insumo(null, insumoForm.getCodigo(), insumoForm.getNome(), insumoForm.getFornecedor(), insumoForm.getCustoCompra(), insumoForm.getValorVenda(), insumoForm.getUnidadeMedida());
    }
}
