package br.com.luds.Luds.unidadedemedida.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeMedidaDTO {
    private UUID id;
    private String nome;
}
