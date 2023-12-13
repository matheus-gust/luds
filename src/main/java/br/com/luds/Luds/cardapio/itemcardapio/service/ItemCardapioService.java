package br.com.luds.Luds.cardapio.itemcardapio.service;

import br.com.luds.Luds.cardapio.itemcardapio.exception.ItemCardapioNaoEncontradaException;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioVariacaoIn;
import br.com.luds.Luds.cardapio.itemcardapio.repository.ItemCardapioRepository;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ItemCardapioService {

    private final ItemCardapioRepository itemCardapioRepository;
    private final ItemCardapioVariacaoService itemCardapioVariacaoService;

    public ItemCardapio buscarItemCardapioPorId(UUID id) {
        return this.itemCardapioRepository.findById(id).orElseThrow(() -> new ItemCardapioNaoEncontradaException());
    }

    public Page<ItemCardapio> listarItemCardapios(ApiPageRequest pageRequest) {
        return this.itemCardapioRepository.findAll(pageRequest.setPage());
    }

    public ItemCardapio inserirItemCardapio(ItemCardapio itemCardapio, List<ItemCardapioVariacaoIn> variacoes) {
        ItemCardapio novoItemCardapio = this.itemCardapioRepository.save(itemCardapio);
        if(!variacoes.isEmpty()) {
            novoItemCardapio.setVariacoes(this.itemCardapioVariacaoService.deltaDeVariacoes(variacoes, novoItemCardapio));
        }
        return this.itemCardapioRepository.save(itemCardapio);
    }

    public ItemCardapio alterarItemCardapio(UUID id, ItemCardapio itemCardapio, List<ItemCardapioVariacaoIn> variacoes) {
        ItemCardapio itemCardapioItemCardapioAtualizade = this.buscarItemCardapioPorId(id);
        itemCardapioItemCardapioAtualizade.atualiza(itemCardapio);
        if(!variacoes.isEmpty()) {
            itemCardapioItemCardapioAtualizade.setVariacoes(this.itemCardapioVariacaoService.deltaDeVariacoes(variacoes, itemCardapioItemCardapioAtualizade));
        }
        return this.itemCardapioRepository.save(itemCardapioItemCardapioAtualizade);
    }

    public void removerItemCardapio(UUID id) {
        ItemCardapio itemCardapio = this.buscarItemCardapioPorId(id);
        this.itemCardapioRepository.delete(itemCardapio);
    }
}
