package br.com.luds.Luds.cardapio.itemcardapio.model.dto;

import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapioDTO {
    private UUID id;
    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private String tamanho;
    private CategoriaCardapioDTO categoria;
    private byte[] imagem;
}
