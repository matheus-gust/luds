package br.com.luds.Luds.venda.model.dto;

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
public class VendaDTO {
    private UUID id;
    private String boletim;
    private String Data;
    private String origem;
    private BigDecimal valor;
    private List<ParteVendaDTO> partes = new ArrayList<>();
}
