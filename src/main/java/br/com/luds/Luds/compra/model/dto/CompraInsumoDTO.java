package br.com.luds.Luds.compra.model.dto;

import br.com.luds.Luds.insumo.model.dto.InsumoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraInsumoDTO {
    private UUID id;
    private CompraDTO compra;
    private InsumoDTO insumo;
    private Integer quantidade;
    private BigDecimal valor;
}
