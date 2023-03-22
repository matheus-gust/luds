package br.com.luds.Luds.insumo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsumoDTO {
    private UUID id;
    private Integer codigo;
    private String nome;
    private String fornecedor;
    private BigDecimal custoCompra;
    private BigDecimal valorVenda;
    private String unidadeMedida;
}
