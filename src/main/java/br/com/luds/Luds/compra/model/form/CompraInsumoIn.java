package br.com.luds.Luds.compra.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraInsumoIn {
    private UUID id;
    private InsumoCompraForm insumo;
    private BigDecimal quantidade;
    private BigDecimal valor;
}
