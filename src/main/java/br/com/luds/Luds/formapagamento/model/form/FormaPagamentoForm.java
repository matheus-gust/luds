package br.com.luds.Luds.formapagamento.model.form;

import br.com.luds.Luds.tipopagamento.model.form.TipoPagamentoForm;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class FormaPagamentoForm {
    private UUID id;
    @NotNull(message = "Nome da Forma de Pagamento não informado")
    private String nome;
    @NotNull(message = "Tipo de pagamento da Forma de Pagamento não informado")
    private TipoPagamentoForm tipoPagamento;
}
