package br.com.luds.Luds.cardapio.categoriacardapio.model.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CategoriaCardapioForm {
    private UUID id;
    private String codigo;
    private String nome;
}
