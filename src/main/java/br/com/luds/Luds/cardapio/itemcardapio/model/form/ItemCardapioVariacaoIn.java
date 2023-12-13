package br.com.luds.Luds.cardapio.itemcardapio.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapioVariacaoIn {
    private UUID variacaoCardapioId;
    private BigDecimal valor;
}
