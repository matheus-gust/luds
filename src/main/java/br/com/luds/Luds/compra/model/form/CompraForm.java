package br.com.luds.Luds.compra.model.form;

import br.com.luds.Luds.commons.model.ModelLocalDateDesserializer;
import br.com.luds.Luds.fornecedor.model.form.FornecedorForm;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CompraForm {
    private UUID id;
    @NotNull(message = "Data da compra não informada")
    @JsonDeserialize(using = ModelLocalDateDesserializer.class)
    private LocalDate data;
    @NotNull(message = "Fornecedor da compra não informado")
    private FornecedorForm fornecedor;
    @NotNull(message = "Forma de pagamento da compra não informada")
    private CompraFormaPagamentoForm formaPagamento;
    @NotNull(message = "Intens da compra não informados")
    private List<CompraInsumoIn> itens = new ArrayList<>();
}
