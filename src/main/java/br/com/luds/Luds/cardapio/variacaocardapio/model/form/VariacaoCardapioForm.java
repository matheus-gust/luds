package br.com.luds.Luds.cardapio.variacaocardapio.model.form;

import br.com.luds.Luds.cardapio.categoriacardapio.model.form.CategoriaCardapioForm;
import lombok.Data;

import java.util.UUID;

@Data
public class VariacaoCardapioForm {
    private UUID id;
    private String nome;
    private CategoriaCardapioForm categoriaCardapio;
}
