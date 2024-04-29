package br.com.luds.Luds.contasapagar.model;

import br.com.luds.Luds.commons.annotation.IgnoreUpdate;
import br.com.luds.Luds.commons.model.LudzEntity;
import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@IgnoreUpdate(fields = {"pago"})
@AllArgsConstructor
@NoArgsConstructor
public class ContasPagar extends LudzEntity<ContasPagar> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String nome;
    private BigDecimal valor;
    private String pago;
    private String dataVencimento;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id")
    private FormaPagamento formaPagamento;

    public ContasPagar(String nome, BigDecimal valor, String dataVencimento, FormaPagamento formaPagamento) {
        this.nome = nome;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.formaPagamento = formaPagamento;
    }
}
