package br.com.luds.Luds.cardapio.variacaocardapio.model.form.dto;

import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VariacaoCardapioDTO {
    private UUID id;
    private String nome;
    private CategoriaCardapioDTO categoriaCardapio;
}
