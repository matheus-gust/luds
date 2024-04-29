package br.com.luds.Luds.venda.model.form;

import br.com.luds.Luds.commons.model.LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class VendaForm {
    private UUID id;
    @NotNull(message = "Data da venda não informado")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate Data;
    @NotNull(message = "Origem da venda não informado")
    private String origem;
    @NotNull(message = "Valor da venda não informado")
    private BigDecimal valor;
    private List<ParteIn> partes = new ArrayList<>();
}
