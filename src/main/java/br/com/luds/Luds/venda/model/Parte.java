package br.com.luds.Luds.venda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Parte {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String nome;
    private BigDecimal valorParte;

    @ManyToOne
    @JoinColumn(name="venda_id")
    private Venda venda;

    @OneToMany(mappedBy = "parte", cascade = CascadeType.ALL)
    private List<VendaItemCardapio> itens = new ArrayList<>();
}
