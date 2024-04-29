package br.com.luds.Luds.venda.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParteIn {
    private UUID id;
    private String nome;
    private BigDecimal valorParte;
    private List<VendaItemCardapioIn> itens = new ArrayList<>();
}
