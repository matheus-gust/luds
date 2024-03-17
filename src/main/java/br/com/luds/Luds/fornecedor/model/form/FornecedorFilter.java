package br.com.luds.Luds.fornecedor.model.form;

import lombok.Data;

import java.util.UUID;

@Data
public class FornecedorFilter {
    private UUID fornecedorId;
    private String codigo;
    private String nome;
}
