package br.com.luds.Luds.compra.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class CompraFormaPagamentoForm {

    @NotNull(message = "Id da Forma de Pagamento não informado")
    private UUID id;
}
