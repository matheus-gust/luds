package br.com.luds.Luds.cardapio.itemcardapio.model.assembler;

import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.categoriacardapio.model.assembler.CategoriaCardapioAssembler;
import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import br.com.luds.Luds.cardapio.categoriacardapio.service.CategoriaCardapioService;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioForm;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemCardapioAssembler implements ILudzAssembler<ItemCardapio, ItemCardapioDTO, ItemCardapioForm> {

    private final CategoriaCardapioAssembler categoriaCardapioAssembler;
    private final CategoriaCardapioService categoriaCardapioService;

    @Override
    public ItemCardapioDTO assembleDTO(ItemCardapio entity) {
        CategoriaCardapioDTO categoriaCardapioDTO = this.categoriaCardapioAssembler.assembleDTO(entity.getCategoria());
        return new ItemCardapioDTO(entity.getId(), entity.getNome(), entity.getDescricao(), entity.getValor(), categoriaCardapioDTO, entity.getImagem());
    }

    @Override
    public ItemCardapio assembleEntity(ItemCardapioForm itemCardapioForm) {
        CategoriaCardapio categoriaCardapio = this.categoriaCardapioService.buscarCategoriaCardapioPorId(itemCardapioForm.getCategoria().getId());
        return ItemCardapio.builder()
                .categoria(categoriaCardapio)
                .descricao(itemCardapioForm.getDescricao())
                .imagem(itemCardapioForm.getImagem())
                .valor(itemCardapioForm.getValor())
                .nome(itemCardapioForm.getNome())
                .build();
    }
}
