package br.com.luds.Luds.solicitacaoinsumo.model.form;

import br.com.luds.Luds.insumo.model.Insumo;
import br.com.luds.Luds.unidade.model.Unidade;
import lombok.Data;

import java.util.UUID;

@Data
public class SolicitacaoInsumoForm {
    private UUID id;
    private String quantidadeSolicitada;
    private UUID unidade;
    private UUID insumo;
}
