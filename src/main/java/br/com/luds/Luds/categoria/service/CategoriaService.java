package br.com.luds.Luds.categoria.service;

import br.com.luds.Luds.categoria.exception.CategoriaNaoEncontradaException;
import br.com.luds.Luds.categoria.model.Categoria;
import br.com.luds.Luds.categoria.repository.CategoriaRepository;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria buscarCategoriaPorId(UUID id) {
        return this.categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNaoEncontradaException());
    }

    public Page<Categoria> listarCategorias(ApiPageRequest pageRequest) {
        return this.categoriaRepository.findAll(pageRequest.setPage());
    }

    public Categoria inserirCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public Categoria alterarCategoria(UUID id, Categoria categoria) {
        Categoria categoriaCategoriaAtualizade = this.buscarCategoriaPorId(id);
        categoriaCategoriaAtualizade.atualiza(categoria);
        return this.categoriaRepository.save(categoriaCategoriaAtualizade);
    }

    public void removerCategoria(UUID id) {
        Categoria categoria = this.buscarCategoriaPorId(id);
        this.categoriaRepository.delete(categoria);
    }
}
