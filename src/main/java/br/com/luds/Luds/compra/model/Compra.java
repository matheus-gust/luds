package br.com.luds.Luds.compra.model;

import br.com.luds.Luds.commons.annotation.IgnoreUpdate;
import br.com.luds.Luds.commons.model.LudzEntity;
import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import br.com.luds.Luds.fornecedor.model.Fornecedor;
import br.com.luds.Luds.venda.model.VendaItemCardapio;
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
@IgnoreUpdate(fields = {"boletim", "itens"})
public class Compra extends LudzEntity<Compra> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String boletim;
    private String data;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id")
    private FormaPagamento formaPagamento;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<CompraInsumo> itens = new ArrayList<>();
}
