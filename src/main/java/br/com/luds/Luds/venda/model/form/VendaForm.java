package br.com.luds.Luds.venda.model.form;

import br.com.luds.Luds.commons.model.ModelLocalDateDesserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class VendaForm {
    private UUID id;
    @JsonDeserialize(using = ModelLocalDateDesserializer.class)
    private LocalDate Data;
    private String origem;
    private BigDecimal valor;
    private List<VendaItemCardapioIn> itens = new ArrayList<>();
}
