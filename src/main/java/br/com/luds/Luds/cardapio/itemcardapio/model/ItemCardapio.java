package br.com.luds.Luds.cardapio.itemcardapio.model;

import br.com.luds.Luds.cardapio.adicionalcardapio.model.AdicionalCardapio;
import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.commons.model.LudzEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapio extends LudzEntity<ItemCardapio> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String nome;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_cardapio_id")
    private CategoriaCardapio categoria;
    private byte[] imagem;

    @OneToMany(mappedBy = "itemCardapio", cascade = CascadeType.ALL)
    private List<ItemCardapioVariacao> variacoes = new ArrayList<>();

}
