package br.com.luds.Luds.compra.model;

import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import br.com.luds.Luds.commons.model.LudzEntity;
import br.com.luds.Luds.insumo.model.Insumo;
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
@Table(name = "compra_insumo")
public class CompraInsumo extends LudzEntity<CompraInsumo> {

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )
        private UUID id;

        @ManyToOne
        @JoinColumn(name="compra_id")
        private Compra compra;

        @ManyToOne
        @JoinColumn(name="insumo_id")
        private Insumo insumo;

        private BigDecimal quantidade;
        private BigDecimal desconto;
        private BigDecimal valor;

}
