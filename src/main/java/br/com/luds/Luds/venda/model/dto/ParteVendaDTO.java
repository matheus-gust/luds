package br.com.luds.Luds.venda.model.dto;

import br.com.luds.Luds.venda.model.Venda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParteVendaDTO {
    private UUID id;
    private String nome;
    private BigDecimal valorParte;
    private Venda venda;
    private List<VendaItemCardapioDTO> itens = new ArrayList<>();
}
