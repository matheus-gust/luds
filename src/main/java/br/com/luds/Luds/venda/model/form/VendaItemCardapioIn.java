package br.com.luds.Luds.venda.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaItemCardapioIn {
    private UUID vendaId;
    private UUID itemId;
    private UUID variacaoId;
    private Integer quantidade;
    private BigDecimal valorTotal;
}
