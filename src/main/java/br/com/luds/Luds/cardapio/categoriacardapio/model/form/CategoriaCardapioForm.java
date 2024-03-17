package br.com.luds.Luds.cardapio.categoriacardapio.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CategoriaCardapioForm {
    private UUID id;
    private String nome;
}
