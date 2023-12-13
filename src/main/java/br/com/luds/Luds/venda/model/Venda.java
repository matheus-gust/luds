package br.com.luds.Luds.venda.model;

import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.commons.annotation.IgnoreUpdate;
import br.com.luds.Luds.commons.model.LudzEntity;
import br.com.luds.Luds.fornecedor.model.Fornecedor;
import br.com.luds.Luds.unidadedemedida.model.UnidadeMedida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IgnoreUpdate(fields = {"boletim"})
public class Venda extends LudzEntity<Venda> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String boletim;
    private LocalDate Data;
    private String origem;
    private BigDecimal valor;

    @OneToMany(mappedBy = "venda")
    private List<VendaItemCardapio> itens = new ArrayList<>();
}
