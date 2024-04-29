package br.com.luds.Luds.tipopagamento.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class TipoPagamentoForm {
    private UUID id;
    @NotNull(message = "Nome do Tipo de Pagamento nao informado")
    private String nome;
}
