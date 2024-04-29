package br.com.luds.Luds.venda.model;

import br.com.luds.Luds.commons.annotation.IgnoreUpdate;
import br.com.luds.Luds.commons.model.LudzEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IgnoreUpdate(fields = {"boletim", "partes"})
public class Venda extends LudzEntity<Venda> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String boletim;
    private String data;
    private String origem;
    private BigDecimal valor;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<Parte> partes = new ArrayList<>();
}
