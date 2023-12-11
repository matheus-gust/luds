package br.com.luds.Luds.cardapio.adicionalcardapio.model.assembler;

import br.com.luds.Luds.cardapio.adicionalcardapio.model.AdicionalCardapio;
import br.com.luds.Luds.cardapio.adicionalcardapio.model.form.dto.AdicionalCardapioDTO;
import br.com.luds.Luds.cardapio.adicionalcardapio.model.form.AdicionalCardapioForm;
import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.categoriacardapio.model.assembler.CategoriaCardapioAssembler;
import br.com.luds.Luds.cardapio.categoriacardapio.service.CategoriaCardapioService;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdicionalCardapioAssembler implements ILudzAssembler<AdicionalCardapio, AdicionalCardapioDTO, AdicionalCardapioForm> {

    private final CategoriaCardapioService categoriaCardapioService;
    private final CategoriaCardapioAssembler categoriaCardapioAssembler;

    @Override
    public AdicionalCardapioDTO assembleDTO(AdicionalCardapio entity) {
        return new AdicionalCardapioDTO(entity.getId(), entity.getNome(), entity.getValor(), entity.getCategoria().getNome());
    }

    @Override
    public AdicionalCardapio assembleEntity(AdicionalCardapioForm adicionalCardapioForm) {
        CategoriaCardapio categoriaCardapio = this.categoriaCardapioService.buscarCategoriaCardapioPorId(adicionalCardapioForm.getCategoriaCardapio());
        return new AdicionalCardapio(null, adicionalCardapioForm.getNome(), adicionalCardapioForm.getValor(), categoriaCardapio);
    }
}
