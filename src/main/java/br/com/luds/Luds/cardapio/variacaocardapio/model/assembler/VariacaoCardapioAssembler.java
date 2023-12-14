package br.com.luds.Luds.cardapio.variacaocardapio.model.assembler;

import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.categoriacardapio.model.assembler.CategoriaCardapioAssembler;
import br.com.luds.Luds.cardapio.categoriacardapio.service.CategoriaCardapioService;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.VariacaoCardapioForm;
import br.com.luds.Luds.cardapio.variacaocardapio.model.dto.VariacaoCardapioDTO;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VariacaoCardapioAssembler implements ILudzAssembler<VariacaoCardapio, VariacaoCardapioDTO, VariacaoCardapioForm> {

    private final CategoriaCardapioService categoriaCardapioService;
    private final CategoriaCardapioAssembler categoriaCardapioAssembler;

    @Override
    public VariacaoCardapioDTO assembleDTO(VariacaoCardapio entity) {
        return new VariacaoCardapioDTO(entity.getId(), entity.getNome(), categoriaCardapioAssembler.assembleDTO(entity.getCategoria()));
    }

    @Override
    public VariacaoCardapio assembleEntity(VariacaoCardapioForm variacaoCardapioForm) {
        CategoriaCardapio categoriaCardapio = this.categoriaCardapioService.buscarCategoriaCardapioPorId(variacaoCardapioForm.getCategoriaCardapio().getId());
        return VariacaoCardapio.builder().nome(variacaoCardapioForm.getNome()).categoria(categoriaCardapio).build();
    }
}
