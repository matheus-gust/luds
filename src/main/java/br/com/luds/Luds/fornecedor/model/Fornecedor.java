package br.com.luds.Luds.fornecedor.model;

import br.com.luds.Luds.commons.model.LudzEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor extends LudzEntity<Fornecedor> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String codigo;
    private String nome;
    private Integer diaEntregaPrev;
    private String diaEntregaSemana;
    private String endereco;
}
