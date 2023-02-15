package br.com.luds.Luds.unidade.model.assembler;

import br.com.luds.Luds.unidade.model.Unidade;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.unidade.model.dto.UnidadeDTO;
import br.com.luds.Luds.unidade.model.form.UnidadeForm;
import org.springframework.stereotype.Component;

@Component
public class UnidadeAssembler implements ILudzAssembler<Unidade, UnidadeDTO, UnidadeForm> {
    @Override
    public UnidadeDTO assembleDTO(Unidade entity) {
        return new UnidadeDTO(entity.getId(), entity.getNome(), entity.getCnpj());
    }

    @Override
    public Unidade assembleEntity(UnidadeForm unidadeForm) {
        return new Unidade(null, unidadeForm.getNome(), unidadeForm.getCnpj());
    }
}
