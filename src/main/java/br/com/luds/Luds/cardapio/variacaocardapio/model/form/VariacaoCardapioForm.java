package br.com.luds.Luds.cardapio.variacaocardapio.model.form;

import lombok.Data;

import java.util.UUID;

@Data
public class VariacaoCardapioForm {
    private UUID id;
    private String nome;
    private UUID categoriaCardapio;
}
