package br.com.luds.Luds.cardapio.itemcardapio.model.dto;

import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapioInfoDTO {
    private UUID id;
    private String nome;
    private String descricao;
    private CategoriaCardapioDTO categoria;
    private List<ItemCardapioVariacaoDTO> variedades = new ArrayList<>();
}
