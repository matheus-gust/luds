package br.com.luds.Luds.cardapio.itemcardapio.model.dto;

import br.com.luds.Luds.cardapio.variacaocardapio.model.form.dto.VariacaoCardapioDTO;
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
    @JsonIgnore
    private ItemCardapioDTO itemCardapio;
    private VariacaoCardapioDTO variedade;
    private BigDecimal valor;
}
