package br.com.luds.Luds.cardapio.variacaocardapio.model.assembler;

import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.VariacaoCardapioForm;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.dto.VariacaoCardapioDTO;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import org.springframework.stereotype.Component;

@Component
public class VariacaoCardapioAssembler implements ILudzAssembler<VariacaoCardapio, VariacaoCardapioDTO, VariacaoCardapioForm> {
    @Override
    public VariacaoCardapioDTO assembleDTO(VariacaoCardapio entity) {
        return new VariacaoCardapioDTO(entity.getId(), entity.getCodigo(), entity.getNome());
    }

    @Override
    public VariacaoCardapio assembleEntity(VariacaoCardapioForm variacaoCardapioForm) {
        return new VariacaoCardapio(null, variacaoCardapioForm.getCodigo(), variacaoCardapioForm.getNome());
    }
}
