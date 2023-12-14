package br.com.luds.Luds.cardapio.itemcardapio.model.assembler;

import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.categoriacardapio.model.assembler.CategoriaCardapioAssembler;
import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import br.com.luds.Luds.cardapio.categoriacardapio.service.CategoriaCardapioService;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioInfoDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioVariacaoDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioForm;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.cardapio.variacaocardapio.model.assembler.VariacaoCardapioAssembler;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.dto.VariacaoCardapioDTO;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ItemCardapioAssembler implements ILudzAssembler<ItemCardapio, ItemCardapioDTO, ItemCardapioForm> {

    private final CategoriaCardapioAssembler categoriaCardapioAssembler;
    private final VariacaoCardapioAssembler variacaoCardapioAssembler;
    private final CategoriaCardapioService categoriaCardapioService;

    @Override
    public ItemCardapioDTO assembleDTO(ItemCardapio entity) {
        CategoriaCardapioDTO categoriaCardapioDTO = this.categoriaCardapioAssembler.assembleDTO(entity.getCategoria());
        return new ItemCardapioDTO(entity.getId(), entity.getNome(), entity.getDescricao(), categoriaCardapioDTO, entity.getImagem());
    }

    @Override
    public ItemCardapio assembleEntity(ItemCardapioForm itemCardapioForm) {
        CategoriaCardapio categoriaCardapio = this.categoriaCardapioService.buscarCategoriaCardapioPorId(itemCardapioForm.getCategoria().getId());
        return ItemCardapio.builder()
                .categoria(categoriaCardapio)
                .descricao(itemCardapioForm.getDescricao())
                .imagem(itemCardapioForm.getImagem())
                .nome(itemCardapioForm.getNome())
                .build();
    }

    public ItemCardapioInfoDTO assembleInfoDTO(ItemCardapio entity) {
        CategoriaCardapioDTO categoriaCardapioDTO = this.categoriaCardapioAssembler.assembleDTO(entity.getCategoria());
        return new ItemCardapioInfoDTO(entity.getId(), entity.getNome(), entity.getDescricao(), categoriaCardapioDTO, assembleVariacaoDTO(entity));
    }

    public ApiCollectionResponse<ItemCardapioInfoDTO> assembleManyInfoDTO(List<ItemCardapio> collection, Integer page, Integer pageSize, boolean hasNext) {
        List<ItemCardapioInfoDTO> dtos = collection.stream().map(entity -> assembleInfoDTO(entity)).collect(Collectors.toList());
        return new ApiCollectionResponse(dtos, page, pageSize, hasNext);
    }

    public List<ItemCardapioVariacaoDTO> assembleVariacaoDTO(ItemCardapio itemCardapio) {
        List<ItemCardapioVariacaoDTO> dtos = new ArrayList<>();
        itemCardapio.getVariacoes().forEach(item -> {
            dtos.add(new ItemCardapioVariacaoDTO(item.getId(), assembleDTO(itemCardapio), variacaoCardapioAssembler.assembleDTO(item.getVariacaoCardapio()), item.getValor()));
        });
        return dtos;
    }
}
