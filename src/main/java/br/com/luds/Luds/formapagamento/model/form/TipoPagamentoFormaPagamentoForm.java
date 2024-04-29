package br.com.luds.Luds.formapagamento.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class TipoPagamentoFormaPagamentoForm {
    @NotNull(message = "Id do Tipo de Pagamento nao informado")
    private UUID id;
    private String nome;
}
