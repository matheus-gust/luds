package br.com.luds.Luds.cardapio.itemcardapio.model.dto;

import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import br.com.luds.Luds.cardapio.variacaocardapio.model.dto.VariacaoCardapioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapioDTO {
    private UUID id;
    private String nome;
    private String codigo;
    private String descricao;
    private CategoriaCardapioDTO categoria;
    private List<ItemCardapioVariacaoDTO> variedades;
    private byte[] imagem;
}
