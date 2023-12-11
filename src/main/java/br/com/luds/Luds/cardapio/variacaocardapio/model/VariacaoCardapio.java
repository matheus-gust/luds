package br.com.luds.Luds.cardapio.variacaocardapio.model;

import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import br.com.luds.Luds.commons.model.LudzEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VariacaoCardapio extends LudzEntity<VariacaoCardapio> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="categoria_cardapio_id")
    private CategoriaCardapio categoria;

    @OneToMany(mappedBy = "variacaoCardapio")
    private List<ItemCardapioVariacao> itensCardapio = new ArrayList<>();
}
