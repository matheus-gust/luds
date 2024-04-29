package br.com.luds.Luds.contasapagar.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ContasPagarFormaPagamentoForm {
    @NotNull(message = "Forma de Pagamento não informado")
    private UUID id;
}
