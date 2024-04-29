package br.com.luds.Luds.venda.model.dto;

import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioVariacaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaItemCardapioDTO {
    private UUID id;
    private ItemCardapioDTO item;
    private ItemCardapioVariacaoDTO variedade;
    private Integer quantidade;
    private BigDecimal valor;
}
