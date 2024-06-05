package br.com.luds.Luds.unidadedemedida.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class UnidadeMedidaForm {
    private UUID id;
    @NotNull(message = "Nome da Unidade de medida não informado")
    private String nome;
}
