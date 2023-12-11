package br.com.luds.Luds.cardapio.itemcardapio.model.form;

import br.com.luds.Luds.cardapio.adicionalcardapio.model.form.AdicionalCardapioForm;
import br.com.luds.Luds.cardapio.categoriacardapio.model.form.CategoriaCardapioForm;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacaoIn;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.VariacaoCardapioForm;
import lombok.Data;

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
    private BigDecimal valor;
    private CategoriaCardapioForm categoria;
    private List<ItemCardapioVariacaoIn> variacoesCardapio = new ArrayList<>();
    private byte[] imagem;
}
