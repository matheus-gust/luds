package br.com.luds.Luds.venda.service;

import br.com.luds.Luds.cardapio.itemcardapio.exception.ItemCardapioNaoEncontradaException;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import br.com.luds.Luds.cardapio.itemcardapio.service.ItemCardapioService;
import br.com.luds.Luds.cardapio.itemcardapio.service.ItemCardapioVariacaoService;
import br.com.luds.Luds.cardapio.variacaocardapio.exception.VariacaoCardapioNaoEncontradaException;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.cardapio.variacaocardapio.service.VariacaoCardapioService;
import br.com.luds.Luds.venda.model.Venda;
import br.com.luds.Luds.venda.model.VendaItemCardapio;
import br.com.luds.Luds.venda.model.form.VendaItemCardapioIn;
import br.com.luds.Luds.venda.repository.VendaItemCardapioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendaItemCardapioService {
    /*private final VendaItemCardapioRepository vendaItemCardapioRepository;
    private final ItemCardapioVariacaoService itemCardapioVariacaoService;

    public List<VendaItemCardapio> deltaDeitens(List<VendaItemCardapioIn> itens, Venda venda) {
        List<VendaItemCardapio> antigosRelacionamentos = this.listarRelacoesPorIdItemEm(venda.getId());

        List<VendaItemCardapio> novosRelacionamentos = new ArrayList<>();
        itens.forEach(itemCard -> {
            if(Objects.isNull(itemCard.getVariedade().getId())) {
                throw new VariacaoCardapioNaoEncontradaException();
            }
            ItemCardapioVariacao itemCardapioVariacao = itemCardapioVariacaoService.buscaItemCardapioVariacaoPorId(itemCard.getVariedade().getId());
            novosRelacionamentos.add(new VendaItemCardapio(null, venda, itemCardapioVariacao, itemCard.getQuantidade(), itemCard.getValor()));
        });

        for (VendaItemCardapio item : antigosRelacionamentos) {
            this.vendaItemCardapioRepository.delete(item);
        }
        return novosRelacionamentos;
    }

    public List<VendaItemCardapio> listarRelacoesPorIdItemEm(UUID id) {
        return* this.vendaItemCardapioRepository.findAllByVendaId(id);
    }*/
}
