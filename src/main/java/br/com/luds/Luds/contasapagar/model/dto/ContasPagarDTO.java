package br.com.luds.Luds.contasapagar.model.dto;

import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import br.com.luds.Luds.formapagamento.model.dto.FormaPagamentoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContasPagarDTO {
    private UUID id;
    private String nome;
    private BigDecimal valor;
    private String pago;
    private String dataVencimento;
    private FormaPagamentoDTO formaPagamento;
}
