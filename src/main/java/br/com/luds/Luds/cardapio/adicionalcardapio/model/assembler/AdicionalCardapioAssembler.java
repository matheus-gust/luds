package br.com.luds.Luds.cardapio.adicionalcardapio.model.assembler;

import br.com.luds.Luds.cardapio.adicionalcardapio.model.AdicionalCardapio;
import br.com.luds.Luds.cardapio.adicionalcardapio.model.form.dto.AdicionalCardapioDTO;
import br.com.luds.Luds.cardapio.adicionalcardapio.model.form.AdicionalCardapioForm;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import org.springframework.stereotype.Component;

@Component
public class AdicionalCardapioAssembler implements ILudzAssembler<AdicionalCardapio, AdicionalCardapioDTO, AdicionalCardapioForm> {
    @Override
    public AdicionalCardapioDTO assembleDTO(AdicionalCardapio entity) {
        return new AdicionalCardapioDTO(entity.getId(), entity.getCodigo(), entity.getNome());
    }

    @Override
    public AdicionalCardapio assembleEntity(AdicionalCardapioForm adicionalCardapioForm) {
        return new AdicionalCardapio(null, adicionalCardapioForm.getCodigo(), adicionalCardapioForm.getNome());
    }
}
