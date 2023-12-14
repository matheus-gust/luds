package br.com.luds.Luds.cardapio.itemcardapio.model.dto;

import br.com.luds.Luds.cardapio.variacaocardapio.model.dto.VariacaoCardapioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapioVariacaoDTO {

    private UUID id;
    private ItemCardapioDTO item;
    private VariacaoCardapioDTO variedade;
    private BigDecimal valor;
}
