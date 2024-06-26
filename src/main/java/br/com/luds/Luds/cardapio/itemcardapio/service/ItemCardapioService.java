package br.com.luds.Luds.cardapio.itemcardapio.service;

import br.com.luds.Luds.cardapio.itemcardapio.exception.ItemCardapioNaoEncontradaException;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioVariacaoIn;
import br.com.luds.Luds.cardapio.itemcardapio.repository.ItemCardapioRepository;
import br.com.luds.Luds.cardapio.itemcardapio.repository.ItemCardapioVariacaoRepository;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ItemCardapioService {

    private final ItemCardapioRepository itemCardapioRepository;
    private final ItemCardapioVariacaoService itemCardapioVariacaoService;
    private final ItemCardapioVariacaoRepository itemCardapioVariacaoRepository;

    public ItemCardapio buscarItemCardapioPorId(UUID id) {
        return this.itemCardapioRepository.findById(id).orElseThrow(() -> new ItemCardapioNaoEncontradaException());
    }

    public Page<ItemCardapio> listarItemCardapios(ApiPageRequest pageRequest) {
        return this.itemCardapioRepository.findAll(pageRequest.setPage());
    }

    public List<ItemCardapio> listarItemCardapioPorIdEm(List<UUID> ids) {
        return this.itemCardapioRepository.findAllById(ids);
    }

    public ItemCardapio inserirItemCardapio(ItemCardapio itemCardapio, List<ItemCardapioVariacaoIn> variacoes) {
        ItemCardapio novoItemCardapio = this.itemCardapioRepository.save(itemCardapio);
        itemCardapio.setVariacoes(new ArrayList<>());
        if(!variacoes.isEmpty()) {
            novoItemCardapio.setVariacoes(this.itemCardapioVariacaoService.deltaDeVariacoes(variacoes, novoItemCardapio));
        }
        this.itemCardapioVariacaoRepository.saveAll(itemCardapio.getVariacoes());
        return this.itemCardapioRepository.save(itemCardapio);
    }

    public ItemCardapio alterarItemCardapio(UUID id, ItemCardapio itemCardapio, List<ItemCardapioVariacaoIn> variacoes) {
        ItemCardapio itemCardapioItemCardapioAtualizade = this.buscarItemCardapioPorId(id);
        List<ItemCardapioVariacao> vars = new ArrayList<>();
        itemCardapioItemCardapioAtualizade.setVariacoes(vars);
        itemCardapioItemCardapioAtualizade.atualiza(itemCardapio);
        this.itemCardapioRepository.save(itemCardapioItemCardapioAtualizade);
        if(!variacoes.isEmpty()) {
            vars = this.itemCardapioVariacaoService.deltaDeVariacoes(variacoes, itemCardapioItemCardapioAtualizade);
        }
        itemCardapioItemCardapioAtualizade.setVariacoes(vars);
        return this.itemCardapioRepository.save(itemCardapioItemCardapioAtualizade);
    }

    public void removerItemCardapio(UUID id) {
        ItemCardapio itemCardapio = this.buscarItemCardapioPorId(id);
        this.itemCardapioRepository.delete(itemCardapio);
    }
}
