package br.com.luds.Luds.cardapio.itemcardapio.model.form;

import br.com.luds.Luds.cardapio.categoriacardapio.model.form.CategoriaCardapioForm;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemCardapioForm {
    private UUID id;
    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private String tamanho;
    private UUID categoriaId;
    private byte[] imagem;
}
