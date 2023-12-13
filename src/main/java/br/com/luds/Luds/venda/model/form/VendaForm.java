package br.com.luds.Luds.venda.model.form;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class VendaForm {
    private UUID id;
    private LocalDate Data;
    private String origem;
    private BigDecimal valor;
    private List<VendaItemCardapioIn> itens = new ArrayList<>();
}
