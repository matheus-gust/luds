package br.com.luds.Luds.compra.model.form;

import br.com.luds.Luds.commons.model.ModelLocalDateDesserializer;
import br.com.luds.Luds.fornecedor.model.form.FornecedorForm;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CompraForm {
    private UUID id;
    @JsonDeserialize(using = ModelLocalDateDesserializer.class)
    private LocalDate data;
    private FornecedorForm fornecedor;
    private List<CompraInsumoIn> itens = new ArrayList<>();
}
