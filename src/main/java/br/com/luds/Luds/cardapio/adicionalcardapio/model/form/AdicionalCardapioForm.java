package br.com.luds.Luds.cardapio.adicionalcardapio.model.form;

import lombok.Data;

import java.util.UUID;

@Data
public class AdicionalCardapioForm {
    private UUID id;
    private String codigo;
    private String nome;
}
