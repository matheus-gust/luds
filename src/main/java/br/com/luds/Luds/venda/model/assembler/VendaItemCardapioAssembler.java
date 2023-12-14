package br.com.luds.Luds.venda.model.assembler;

import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import br.com.luds.Luds.cardapio.itemcardapio.model.assembler.ItemCardapioAssembler;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioVariacaoDTO;
import br.com.luds.Luds.cardapio.itemcardapio.service.ItemCardapioService;
import br.com.luds.Luds.cardapio.itemcardapio.service.ItemCardapioVariacaoService;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.cardapio.variacaocardapio.model.assembler.VariacaoCardapioAssembler;
import br.com.luds.Luds.cardapio.variacaocardapio.model.dto.VariacaoCardapioDTO;
import br.com.luds.Luds.cardapio.variacaocardapio.service.VariacaoCardapioService;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.venda.model.VendaItemCardapio;
import br.com.luds.Luds.venda.model.dto.VendaItemCardapioDTO;
import br.com.luds.Luds.venda.model.form.VendaItemCardapioIn;
import br.com.luds.Luds.venda.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VendaItemCardapioAssembler implements ILudzAssembler<VendaItemCardapio, VendaItemCardapioDTO, VendaItemCardapioIn> {

    private final ItemCardapioAssembler itemCardapioAssembler;
    private final ItemCardapioVariacaoService itemCardapioVariacaoService;
    @Override
    public VendaItemCardapioDTO assembleDTO(VendaItemCardapio entity) {
        ItemCardapioVariacaoDTO variacaoCardapioDTO = itemCardapioAssembler.assembleVariacaoDTO(entity.getVariacao());
        return new VendaItemCardapioDTO(entity.getId(), null, variacaoCardapioDTO, entity.getQuantidade(), entity.getValorTotal());
    }

    @Override
    public VendaItemCardapio assembleEntity(VendaItemCardapioIn vendaItemCardapioIn) {
        ItemCardapioVariacao itemCardapioVariacao = this.itemCardapioVariacaoService.buscaItemCardapioVariacaoPorId(vendaItemCardapioIn.getVariedade().getId());
        return new VendaItemCardapio(null, null, itemCardapioVariacao, vendaItemCardapioIn.getQuantidade(), vendaItemCardapioIn.getValor());
    }
}
