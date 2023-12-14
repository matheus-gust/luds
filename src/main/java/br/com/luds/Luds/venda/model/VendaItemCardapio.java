package br.com.luds.Luds.venda.model;

import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.commons.model.LudzEntity;
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
@Table(name = "venda_item_cardapio")
public class VendaItemCardapio extends LudzEntity<Venda> {

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )
        private UUID id;

        @ManyToOne
        @JoinColumn(name="venda_id")
        private Venda venda;

        @ManyToOne
        @JoinColumn(name="item_cardapio_variacao_id")
        private ItemCardapioVariacao variacao;

        private Integer quantidade;
        private BigDecimal valorTotal;

}
