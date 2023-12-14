package br.com.luds.Luds.cardapio.itemcardapio.application;

import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioInfoDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioVariacaoIn;
import br.com.luds.Luds.cardapio.itemcardapio.model.assembler.ItemCardapioAssembler;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioForm;
import br.com.luds.Luds.cardapio.itemcardapio.service.ItemCardapioService;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ItemCardapioApplication {

    private final ItemCardapioService itemCardapioService;
    private final ItemCardapioAssembler itemCardapioAssembler;

    public ApiCollectionResponse<ItemCardapioDTO> listarItemCardapios(ApiPageRequest pageRequest) {
        Page pageItemCardapio = this.itemCardapioService.listarItemCardapios(pageRequest);
        return itemCardapioAssembler.assembleManyDTO(pageItemCardapio.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageItemCardapio.hasNext());
    }

    public ApiCollectionResponse<ItemCardapioInfoDTO> listarItemCardapiosInfo(ApiPageRequest pageRequest) {
        Page pageItemCardapio = this.itemCardapioService.listarItemCardapios(pageRequest);
        return itemCardapioAssembler.assembleManyInfoDTO(pageItemCardapio.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageItemCardapio.hasNext());
    }

    public ItemCardapioDTO buscarItemCardapioPorId(UUID id) {
        return this.itemCardapioAssembler.assembleDTO(this.itemCardapioService.buscarItemCardapioPorId(id));
    }

    public ItemCardapioDTO inserirItemCardapio(ItemCardapioForm itemCardapio) {
        List<ItemCardapioVariacaoIn> variacoes = itemCardapio.getVariedades();
        return this.itemCardapioAssembler.assembleDTO(this.itemCardapioService.inserirItemCardapio(
                this.itemCardapioAssembler.assembleEntity(itemCardapio), variacoes));
    }

    public ItemCardapioDTO alterarItemCardapio(UUID id, ItemCardapioForm itemCardapio) {
        List<ItemCardapioVariacaoIn> variacoes = itemCardapio.getVariedades();
        return this.itemCardapioAssembler.assembleDTO(this.itemCardapioService.alterarItemCardapio(id, this.itemCardapioAssembler.assembleEntity(itemCardapio), variacoes));
    }

    public void removerItemCardapio(UUID id) {
        this.itemCardapioService.removerItemCardapio(id);
    }
}
