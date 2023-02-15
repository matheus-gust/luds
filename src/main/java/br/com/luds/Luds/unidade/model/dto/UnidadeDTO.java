package br.com.luds.Luds.unidade.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeDTO {
    private UUID id;
    private String nome;
    private String cnpj;
}
