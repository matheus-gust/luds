package br.com.luds.Luds.cardapio.itemcardapio.model.form;

import br.com.luds.Luds.cardapio.categoriacardapio.model.form.CategoriaCardapioForm;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ItemCardapioForm {
    private UUID id;
    private String codigo;
    private String nome;
    private String descricao;
    @Valid
    @NotNull(message = "Categoria não selecionada")
    private CategoriaCardapioForm categoria;
    @NotEmpty(message = "Variedades não selecionadas")
    private List<ItemCardapioVariacaoIn> variedades = new ArrayList<>();
    private byte[] imagem;
}
