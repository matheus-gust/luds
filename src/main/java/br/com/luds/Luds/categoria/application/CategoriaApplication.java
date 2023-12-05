package br.com.luds.Luds.categoria.application;

import br.com.luds.Luds.categoria.model.assembler.CategoriaAssembler;
import br.com.luds.Luds.categoria.model.dto.CategoriaDTO;
import br.com.luds.Luds.categoria.model.form.CategoriaForm;
import br.com.luds.Luds.categoria.service.CategoriaService;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoriaApplication {

    private final CategoriaService categoriaService;
    private final CategoriaAssembler categoriaAssembler;

    public ApiCollectionResponse<CategoriaDTO> listarCategorias(ApiPageRequest pageRequest) {
        Page pageCategoria = this.categoriaService.listarCategorias(pageRequest);
        return categoriaAssembler.assembleManyDTO(pageCategoria.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageCategoria.hasNext());
    }

    public CategoriaDTO buscarCategoriaPorId(UUID id) {
        return this.categoriaAssembler.assembleDTO(this.categoriaService.buscarCategoriaPorId(id));
    }

    public CategoriaDTO inserirCategoria(CategoriaForm categoria) {
        return this.categoriaAssembler.assembleDTO(this.categoriaService.inserirCategoria(this.categoriaAssembler.assembleEntity(categoria)));
    }

    public CategoriaDTO alterarCategoria(UUID id, CategoriaForm categoria) {
        return this.categoriaAssembler.assembleDTO(this.categoriaService.alterarCategoria(id, this.categoriaAssembler.assembleEntity(categoria)));
    }

    public void removerCategoria(UUID id) {
        this.categoriaService.removerCategoria(id);
    }
}
