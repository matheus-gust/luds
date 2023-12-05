package br.com.luds.Luds.categoria.model;

import br.com.luds.Luds.commons.model.LudzEntity;
import br.com.luds.Luds.fornecedor.model.Fornecedor;
import br.com.luds.Luds.unidadedemedida.model.UnidadeMedida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Categoria extends LudzEntity<Categoria> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String nome;
}
