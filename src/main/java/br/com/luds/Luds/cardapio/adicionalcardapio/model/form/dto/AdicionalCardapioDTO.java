package br.com.luds.Luds.cardapio.adicionalcardapio.model.form.dto;

import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdicionalCardapioDTO {
    private UUID id;
    private String nome;
    private Double valor;
    private String categoriaCardapio;
}
