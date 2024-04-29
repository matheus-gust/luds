package br.com.luds.Luds.venda.model.assembler;

import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import br.com.luds.Luds.cardapio.itemcardapio.model.assembler.ItemCardapioAssembler;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioVariacaoDTO;
import br.com.luds.Luds.cardapio.itemcardapio.service.ItemCardapioVariacaoService;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.venda.model.Parte;
import br.com.luds.Luds.venda.model.VendaItemCardapio;
import br.com.luds.Luds.venda.model.dto.VendaItemCardapioDTO;
import br.com.luds.Luds.venda.model.form.VendaItemCardapioIn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VendaItemCardapioAssembler implements ILudzAssembler<VendaItemCardapio, VendaItemCardapioDTO, VendaItemCardapioIn> {

    private final ItemCardapioAssembler itemCardapioAssembler;
    private final ItemCardapioVariacaoService itemCardapioVariacaoService;
    @Override
    public VendaItemCardapioDTO assembleDTO(VendaItemCardapio entity) {
        ItemCardapioVariacaoDTO variacaoCardapioDTO = itemCardapioAssembler.assembleVariacaoDTO(entity.getVariacao());
        return new VendaItemCardapioDTO(entity.getId(), itemCardapioAssembler.assembleDTO(entity.getVariacao().getItemCardapio()), variacaoCardapioDTO, entity.getQuantidade(), entity.getValorTotal());
    }

    @Override
    public VendaItemCardapio assembleEntity(VendaItemCardapioIn vendaItemCardapioIn) {
        ItemCardapioVariacao itemCardapioVariacao = this.itemCardapioVariacaoService.buscaItemCardapioVariacaoPorId(vendaItemCardapioIn.getVariedade().getId());
        return new VendaItemCardapio(null, null, itemCardapioVariacao, vendaItemCardapioIn.getQuantidade(), vendaItemCardapioIn.getValor());
    }
    public VendaItemCardapio assembleEntity(VendaItemCardapioIn vendaItemCardapioIn, Parte parte) {
        ItemCardapioVariacao itemCardapioVariacao = this.itemCardapioVariacaoService.buscaItemCardapioVariacaoPorId(vendaItemCardapioIn.getVariedade().getId());
        return new VendaItemCardapio(null, parte, itemCardapioVariacao, vendaItemCardapioIn.getQuantidade(), vendaItemCardapioIn.getValor());
    }
}
