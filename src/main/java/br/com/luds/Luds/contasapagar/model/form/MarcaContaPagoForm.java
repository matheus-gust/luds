package br.com.luds.Luds.contasapagar.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MarcaContaPagoForm {

    @NotNull(message = "Forma de Pagamento da Conta não informado")
    private ContasPagarFormaPagamentoForm formaPagamento;
}
