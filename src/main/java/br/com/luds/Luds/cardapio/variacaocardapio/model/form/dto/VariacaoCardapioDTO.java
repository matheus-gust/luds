package br.com.luds.Luds.cardapio.variacaocardapio.model.form.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VariacaoCardapioDTO {
    private UUID id;
    private String codigo;
    private String nome;
}
