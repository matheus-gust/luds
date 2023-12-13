package br.com.luds.Luds.venda.model.assembler;

import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.assembler.ItemCardapioAssembler;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioDTO;
import br.com.luds.Luds.cardapio.itemcardapio.service.ItemCardapioService;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.cardapio.variacaocardapio.model.assembler.VariacaoCardapioAssembler;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.dto.VariacaoCardapioDTO;
import br.com.luds.Luds.cardapio.variacaocardapio.service.VariacaoCardapioService;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.venda.model.VendaItemCardapio;
import br.com.luds.Luds.venda.model.dto.VendaDTO;
import br.com.luds.Luds.venda.model.dto.VendaItemCardapioDTO;
import br.com.luds.Luds.venda.model.form.VendaItemCardapioIn;
import br.com.luds.Luds.venda.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VendaItemCardapioAssembler implements ILudzAssembler<VendaItemCardapio, VendaItemCardapioDTO, VendaItemCardapioIn> {

    private final VariacaoCardapioAssembler variacaoCardapioAssembler;
    private final ItemCardapioAssembler itemCardapioAssembler;

    private final VendaService vendaService;
    private final VariacaoCardapioService variacaoCardapioService;
    private final ItemCardapioService itemCardapioService;

    @Override
    public VendaItemCardapioDTO assembleDTO(VendaItemCardapio entity) {
        ItemCardapioDTO itemCardapioDTO = itemCardapioAssembler.assembleDTO(entity.getItemCardapio());
        VariacaoCardapioDTO variacaoCardapioDTO = variacaoCardapioAssembler.assembleDTO(entity.getVariacao());

        return new VendaItemCardapioDTO(entity.getId(), null, itemCardapioDTO, variacaoCardapioDTO, entity.getQuantidade(), entity.getValorTotal());
    }

    @Override
    public VendaItemCardapio assembleEntity(VendaItemCardapioIn vendaItemCardapioIn) {
        ItemCardapio itemCardapio = itemCardapioService.buscarItemCardapioPorId(vendaItemCardapioIn.getItemId());
        VariacaoCardapio variacaoCardapio = variacaoCardapioService.buscarVariacaoCardapioPorId(vendaItemCardapioIn.getVariacaoId());
        return new VendaItemCardapio(null, null, itemCardapio, variacaoCardapio, vendaItemCardapioIn.getQuantidade(), vendaItemCardapioIn.getValorTotal());
    }
}
