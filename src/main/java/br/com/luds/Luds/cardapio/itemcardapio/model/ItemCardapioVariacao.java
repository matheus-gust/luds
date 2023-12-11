package br.com.luds.Luds.cardapio.itemcardapio.model;

import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_cardapio_variacao_cardapio")
public class ItemCardapioVariacao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "item_cardapio_id")
    private ItemCardapio itemCardapio;
    @ManyToOne
    @JoinColumn(name = "variacao_cardapio_id")
    private VariacaoCardapio variacaoCardapio;
    private BigDecimal valor;
}
