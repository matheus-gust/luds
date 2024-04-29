package br.com.luds.Luds.tipopagamento.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoPagamentoDTO {
    private UUID id;
    private String nome;
}
