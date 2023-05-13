package br.com.luds.Luds.insumo.model.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class InsumoForm {
    private UUID id;
    private String codigo;
    private String nome;
    private String fornecedor;
    private BigDecimal custoCompra;
    private BigDecimal valorVenda;
    private String unidadeMedida;
}
