package br.com.luds.Luds.unidade.model.form;

import lombok.Data;

import java.util.UUID;

@Data
public class UnidadeForm {
    private UUID id;
    private Integer codigo;
    private String localidade;
    private String nome;
    private String cnpj;
}
