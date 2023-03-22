package br.com.luds.Luds.solicitacaoinsumo.model.dto;

import br.com.luds.Luds.insumo.model.Insumo;
import br.com.luds.Luds.unidade.model.Unidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoInsumoDTO {
    private UUID id;
    private String quantidadeSolicitada;
    private Unidade unidade;
    private Insumo insumo;
}
