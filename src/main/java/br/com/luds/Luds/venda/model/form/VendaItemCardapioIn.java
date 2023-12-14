package br.com.luds.Luds.venda.model.form;

import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioForm;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioVariacaoIn;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.VariacaoCardapioForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaItemCardapioIn {
    private UUID id;
    private ItemCardapioForm item;
    private ItemCardapioVariacaoIn variedade;
    private Integer quantidade;
    private BigDecimal valor;
}
