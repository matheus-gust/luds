package br.com.luds.Luds.insumo.model.form;

import br.com.luds.Luds.unidadedemedida.model.form.UnidadeMedidaForm;
import lombok.Data;

import java.util.UUID;

@Data
public class InsumoForm {
    private UUID id;
    private String codigo;
    private String nome;
    private UnidadeMedidaForm unidadeMedida;
}
