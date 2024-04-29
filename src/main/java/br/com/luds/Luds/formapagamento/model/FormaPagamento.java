package br.com.luds.Luds.formapagamento.model;

import br.com.luds.Luds.commons.model.LudzEntity;
import br.com.luds.Luds.tipopagamento.model.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagamento extends LudzEntity<FormaPagamento> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "tipo_pagamento_id")
    private TipoPagamento tipoPagamento;
}
