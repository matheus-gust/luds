package br.com.luds.Luds.fornecedor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO {
    private UUID id;
    private String codigo;
    private String nome;
    private Integer diaEntregaPrev;
    private String diaEntregaSemana;
    private String endereco;
}
