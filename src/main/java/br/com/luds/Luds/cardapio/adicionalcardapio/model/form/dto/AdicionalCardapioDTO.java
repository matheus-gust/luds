package br.com.luds.Luds.cardapio.adicionalcardapio.model.form.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdicionalCardapioDTO {
    private UUID id;
    private String codigo;
    private String nome;
}
