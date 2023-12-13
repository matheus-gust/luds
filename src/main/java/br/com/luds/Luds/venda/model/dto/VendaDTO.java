package br.com.luds.Luds.venda.model.dto;

import br.com.luds.Luds.venda.model.VendaItemCardapio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {
    private UUID id;
    private String boletim;
    private LocalDate Data;
    private String origem;
    private BigDecimal valor;
    private List<VendaItemCardapioDTO> itens = new ArrayList<>();
}
