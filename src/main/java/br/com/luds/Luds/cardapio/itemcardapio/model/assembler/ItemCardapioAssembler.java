package br.com.luds.Luds.cardapio.itemcardapio.model.assembler;

import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.categoriacardapio.model.assembler.CategoriaCardapioAssembler;
import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import br.com.luds.Luds.cardapio.categoriacardapio.service.CategoriaCardapioService;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapio;
import br.com.luds.Luds.cardapio.itemcardapio.model.ItemCardapioVariacao;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioInfoDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioVariacaoDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioForm;
import br.com.luds.Luds.cardapio.variacaocardapio.model.assembler.VariacaoCardapioAssembler;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ItemCardapioAssembler implements ILudzAssembler<ItemCardapio, ItemCardapioDTO, ItemCardapioForm> {

    private final CategoriaCardapioAssembler categoriaCardapioAssembler;
    private final VariacaoCardapioAssembler variacaoCardapioAssembler;
    private final CategoriaCardapioService categoriaCardapioService;

    @Override
    public ItemCardapioDTO assembleDTO(ItemCardapio entity) {
        CategoriaCardapioDTO categoriaCardapioDTO = this.categoriaCardapioAssembler.assembleDTO(entity.getCategoria());
        return new ItemCardapioDTO(entity.getId(), entity.getNome(), entity.getCodigo(), entity.getDescricao(), categoriaCardapioDTO, assembleManyVariacaoDTO(entity.getVariacoes()),  entity.getImagem());
    }

    @Override
    public ItemCardapio assembleEntity(ItemCardapioForm itemCardapioForm) {
        CategoriaCardapio categoriaCardapio = this.categoriaCardapioService.buscarCategoriaCardapioPorId(itemCardapioForm.getCategoria().getId());
        return ItemCardapio.builder()
                .categoria(categoriaCardapio)
                .codigo(itemCardapioForm.getCodigo())
                .descricao(itemCardapioForm.getDescricao())
                .imagem(itemCardapioForm.getImagem())
                .nome(itemCardapioForm.getNome())
                .build();
    }

    public ItemCardapioInfoDTO assembleInfoDTO(ItemCardapio entity) {
        CategoriaCardapioDTO categoriaCardapioDTO = this.categoriaCardapioAssembler.assembleDTO(entity.getCategoria());
        return new ItemCardapioInfoDTO(entity.getId(), entity.getNome(), entity.getDescricao(), categoriaCardapioDTO, assembleManyVariacaoDTO(entity.getVariacoes()));
    }

    public ApiCollectionResponse<ItemCardapioInfoDTO> assembleManyInfoDTO(List<ItemCardapio> collection, Integer page, Integer pageSize, boolean hasNext) {
        List<ItemCardapioInfoDTO> dtos = collection.stream().map(this::assembleInfoDTO).collect(Collectors.toList());
        return new ApiCollectionResponse<>(dtos, page, pageSize, hasNext);
    }

    public ItemCardapioDTO assemblenoImageDTO(ItemCardapio entity) {
        CategoriaCardapioDTO categoriaCardapioDTO = this.categoriaCardapioAssembler.assembleDTO(entity.getCategoria());
        List<ItemCardapioVariacaoDTO> variacoes = entity.getVariacoes().stream().map(
                var -> new ItemCardapioVariacaoDTO(
                            var.getId(),
                            null,
                            variacaoCardapioAssembler.assembleDTO(var.getVariacaoCardapio()),
                            var.getValor()
                        )
        ).collect(Collectors.toList());
        return new ItemCardapioDTO(entity.getId(), entity.getNome(), entity.getCodigo(), entity.getDescricao(), categoriaCardapioDTO, variacoes, null);
    }

    public ItemCardapioVariacaoDTO assembleVariacaoDTO(ItemCardapioVariacao itemCardapioVariacao) {
        return new ItemCardapioVariacaoDTO(itemCardapioVariacao.getId(), assemblenoImageDTO(itemCardapioVariacao.getItemCardapio()), variacaoCardapioAssembler.assembleDTO(itemCardapioVariacao.getVariacaoCardapio()), itemCardapioVariacao.getValor());
    }

    public List<ItemCardapioVariacaoDTO> assembleManyVariacaoDTO(List<ItemCardapioVariacao> variacao) {
        List<ItemCardapioVariacaoDTO> dtos = new ArrayList<>();
        variacao.forEach(varia -> {
            dtos.add(new ItemCardapioVariacaoDTO(varia.getId(), assemblenoImageDTO(varia.getItemCardapio()), variacaoCardapioAssembler.assembleDTO(varia.getVariacaoCardapio()), varia.getValor()));
        });
        return dtos;
    }
}
