package br.com.luds.Luds.categoria.model.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CategoriaForm {
    private UUID id;
    private String nome;
}
