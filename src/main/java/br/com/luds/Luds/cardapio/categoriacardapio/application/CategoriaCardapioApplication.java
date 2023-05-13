package br.com.luds.Luds.cardapio.categoriacardapio.application;

import br.com.luds.Luds.cardapio.categoriacardapio.model.assembler.CategoriaCardapioAssembler;
import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import br.com.luds.Luds.cardapio.categoriacardapio.model.form.CategoriaCardapioForm;
import br.com.luds.Luds.cardapio.categoriacardapio.service.CategoriaCardapioService;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoriaCardapioApplication {

    private final CategoriaCardapioService categoriaCardapioService;
    private final CategoriaCardapioAssembler categoriaCardapioAssembler;

    public ApiCollectionResponse<CategoriaCardapioDTO> listarCategoriaCardapios(ApiPageRequest pageRequest) {
        Page pageCategoriaCardapio = this.categoriaCardapioService.listarCategoriaCardapios(pageRequest);
        return categoriaCardapioAssembler.assembleManyDTO(pageCategoriaCardapio.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageCategoriaCardapio.hasNext());
    }

    public CategoriaCardapioDTO buscarCategoriaCardapioPorId(UUID id) {
        return this.categoriaCardapioAssembler.assembleDTO(this.categoriaCardapioService.buscarCategoriaCardapioPorId(id));
    }

    public CategoriaCardapioDTO inserirCategoriaCardapio(CategoriaCardapioForm categoriaCardapio) {
        return this.categoriaCardapioAssembler.assembleDTO(this.categoriaCardapioService.inserirCategoriaCardapio(this.categoriaCardapioAssembler.assembleEntity(categoriaCardapio)));
    }

    public CategoriaCardapioDTO alterarCategoriaCardapio(UUID id, CategoriaCardapioForm categoriaCardapio) {
        return this.categoriaCardapioAssembler.assembleDTO(this.categoriaCardapioService.alterarCategoriaCardapio(id, this.categoriaCardapioAssembler.assembleEntity(categoriaCardapio)));
    }

    public void removerCategoriaCardapio(UUID id) {
        this.categoriaCardapioService.removerCategoriaCardapio(id);
    }
}
