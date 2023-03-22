package br.com.luds.Luds.insumo.model;

import br.com.luds.Luds.commons.model.LudzEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Insumo extends LudzEntity<Insumo> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private Integer codigo;
    private String nome;
    private String fornecedor;
    private BigDecimal custoCompra;
    private BigDecimal valorVenda;
    private String unidadeMedida;
}
