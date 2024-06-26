package br.com.luds.Luds.cardapio.itemcardapio.service;

import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioVariacaoIn;
import br.com.luds.Luds.cardapio.itemcardapio.repository.ItemCardapioVariacaoRepository;
import br.com.luds.Luds.cardapio.variacaocardapio.exception.VariacaoCardapioNaoEncontradaException;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.cardapio.variacaocardapio.service.VariacaoCardapioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemCardapioVariacaoService {

    private final ItemCardapioVariacaoRepository itemCardapioVariacaoRepository;
    private final VariacaoCardapioService variacaoCardapioService;

    public ItemCardapioVariacao buscaItemCardapioVariacaoPorId(UUID id) {
        return itemCardapioVariacaoRepository.findById(id).orElseThrow(VariacaoCardapioNaoEncontradaException::new);
    }

    public List<ItemCardapioVariacao> deltaDeVariacoes(List<ItemCardapioVariacaoIn> variacoes, ItemCardapio itemCardapio) {
        List<VariacaoCardapio> variacaoCardapios = this.variacaoCardapioService.listarVariacoesPorIdEm(variacoes.stream().map(var -> var.getVariedade().getId()).collect(Collectors.toList()));
        List<ItemCardapioVariacao> antigosRelacionamentos = this.listarRelacoesPorIdVariedadeEm(itemCardapio.getVariacoes().stream().map(var -> var.getVariacaoCardapio().getId()).collect(Collectors.toList()));

        List<ItemCardapioVariacao> novosRelacionamentos = new ArrayList<>();
        variacoes.forEach(variacaoCardapio -> {
            VariacaoCardapio variacao = variacaoCardapios.stream().filter(var -> var.getId().equals(variacaoCardapio.getVariedade().getId())).findFirst().orElseThrow(VariacaoCardapioNaoEncontradaException::new);
            novosRelacionamentos.add(new ItemCardapioVariacao(null, itemCardapio, variacao, variacaoCardapio.getValor()));
        });

        itemCardapioVariacaoRepository.deleteAll(antigosRelacionamentos);
        return novosRelacionamentos;
    }

    public List<ItemCardapioVariacao> listarRelacoesPorIdVariedadeEm(List<UUID> ids) {
        return this.itemCardapioVariacaoRepository.findAllByVariacaoCardapioIdIn(ids);
    }
}
