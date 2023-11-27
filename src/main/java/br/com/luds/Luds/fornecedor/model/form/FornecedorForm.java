package br.com.luds.Luds.fornecedor.model.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class FornecedorForm {
    private UUID id;
    private String codigo;
    private String nome;
    private Integer diaEntregaPrev;
    private String diaEntregaSemana;
    private String endereco;
}
