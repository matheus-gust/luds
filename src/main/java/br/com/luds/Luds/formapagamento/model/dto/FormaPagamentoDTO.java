package br.com.luds.Luds.formapagamento.model.dto;

import br.com.luds.Luds.tipopagamento.model.dto.TipoPagamentoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamentoDTO {
    private UUID id;
    private String nome;
    private TipoPagamentoDTO tipoPagamento;
}
