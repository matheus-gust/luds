package br.com.luds.Luds.cardapio.categoriacardapio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaCardapioDTO {
    private UUID id;
    private String codigo;
    private String nome;
}
