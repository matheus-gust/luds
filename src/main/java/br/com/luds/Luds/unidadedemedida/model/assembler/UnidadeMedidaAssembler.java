package br.com.luds.Luds.unidadedemedida.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.unidadedemedida.model.UnidadeMedida;
import br.com.luds.Luds.unidadedemedida.model.dto.UnidadeMedidaDTO;
import br.com.luds.Luds.unidadedemedida.model.form.UnidadeMedidaForm;
import org.springframework.stereotype.Component;

@Component
public class UnidadeMedidaAssembler implements ILudzAssembler<UnidadeMedida, UnidadeMedidaDTO, UnidadeMedidaForm> {
    @Override
    public UnidadeMedidaDTO assembleDTO(UnidadeMedida entity) {
        return new UnidadeMedidaDTO(entity.getId(), entity.getNome());
    }

    @Override
    public UnidadeMedida assembleEntity(UnidadeMedidaForm unidadeMedidaForm) {
        return new UnidadeMedida(null, unidadeMedidaForm.getNome());
    }
}
