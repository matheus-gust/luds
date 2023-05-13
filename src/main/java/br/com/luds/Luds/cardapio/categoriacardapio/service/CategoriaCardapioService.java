package br.com.luds.Luds.cardapio.categoriacardapio.service;

import br.com.luds.Luds.cardapio.categoriacardapio.exception.CategoriaCardapioNaoEncontradaException;
import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.categoriacardapio.repository.CategoriaCardapioRepository;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoriaCardapioService {

    private final CategoriaCardapioRepository categoriaCardapioRepository;

    public CategoriaCardapio buscarCategoriaCardapioPorId(UUID id) {
        return this.categoriaCardapioRepository.findById(id).orElseThrow(() -> new CategoriaCardapioNaoEncontradaException());
    }

    public Page<CategoriaCardapio> listarCategoriaCardapios(ApiPageRequest pageRequest) {
        return this.categoriaCardapioRepository.findAll(pageRequest.setPage());
    }

    public CategoriaCardapio inserirCategoriaCardapio(CategoriaCardapio categoriaCardapio) {
        return this.categoriaCardapioRepository.save(categoriaCardapio);
    }

    public CategoriaCardapio alterarCategoriaCardapio(UUID id, CategoriaCardapio categoriaCardapio) {
        CategoriaCardapio categoriaCardapioCategoriaCardapioAtualizade = this.buscarCategoriaCardapioPorId(id);
        categoriaCardapioCategoriaCardapioAtualizade.atualiza(categoriaCardapio);
        return this.categoriaCardapioRepository.save(categoriaCardapioCategoriaCardapioAtualizade);
    }

    public void removerCategoriaCardapio(UUID id) {
        CategoriaCardapio categoriaCardapio = this.buscarCategoriaCardapioPorId(id);
        this.categoriaCardapioRepository.delete(categoriaCardapio);
    }
}
