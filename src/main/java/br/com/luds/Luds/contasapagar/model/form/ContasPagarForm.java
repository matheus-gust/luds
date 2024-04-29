package br.com.luds.Luds.contasapagar.model.form;

import br.com.luds.Luds.commons.model.LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ContasPagarForm {
    private UUID id;

    @NotNull(message = "Nome da Conta não informado")
    private String nome;
    @NotNull(message = "Valor da Conta não informado")
    private BigDecimal valor;
    @NotNull(message = "Data vencimento da Conta não informado")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dataVencimento;
}
