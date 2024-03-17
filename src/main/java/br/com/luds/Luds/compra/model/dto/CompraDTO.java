package br.com.luds.Luds.compra.model.dto;

import br.com.luds.Luds.fornecedor.model.dto.FornecedorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {
    private UUID id;
    private String boletim;
    private String data;
    private FornecedorDTO fornecedor;
    private BigDecimal valorTotal;
    private List<CompraInsumoDTO> itens = new ArrayList<>();
}
