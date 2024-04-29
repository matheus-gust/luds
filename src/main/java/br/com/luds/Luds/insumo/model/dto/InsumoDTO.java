package br.com.luds.Luds.insumo.model.dto;

import br.com.luds.Luds.unidadedemedida.model.dto.UnidadeMedidaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsumoDTO {
    private UUID id;
    private String codigo;
    private String nome;
    private UnidadeMedidaDTO unidadeMedida;
}
