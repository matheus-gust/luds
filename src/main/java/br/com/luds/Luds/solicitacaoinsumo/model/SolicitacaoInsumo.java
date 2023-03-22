package br.com.luds.Luds.solicitacaoinsumo.model;

import br.com.luds.Luds.commons.model.LudzEntity;
import br.com.luds.Luds.insumo.model.Insumo;
import br.com.luds.Luds.unidade.model.Unidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoInsumo extends LudzEntity<SolicitacaoInsumo> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private BigDecimal quantidadeSolicitada;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;
    @ManyToOne
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;
}
