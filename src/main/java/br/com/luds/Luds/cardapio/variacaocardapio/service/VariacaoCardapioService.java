package br.com.luds.Luds.cardapio.variacaocardapio.service;

import br.com.luds.Luds.cardapio.variacaocardapio.exception.VariacaoCardapioNaoEncontradaException;
import br.com.luds.Luds.cardapio.variacaocardapio.model.VariacaoCardapio;
import br.com.luds.Luds.cardapio.variacaocardapio.repository.VariacaoCardapioRepository;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VariacaoCardapioService {

    private final VariacaoCardapioRepository variacaoCardapioRepository;

    public VariacaoCardapio buscarVariacaoCardapioPorId(UUID id) {
        return this.variacaoCardapioRepository.findById(id).orElseThrow(() -> new VariacaoCardapioNaoEncontradaException());
    }

    public Page<VariacaoCardapio> listarVariacaoCardapios(ApiPageRequest pageRequest) {
        return this.variacaoCardapioRepository.findAll(pageRequest.setPage());
    }

    public List<VariacaoCardapio> listarVariacoesPorIdEm(List<UUID> ids) {
        return this.variacaoCardapioRepository.findAllByIdIn(ids);
    }

    public VariacaoCardapio inserirVariacaoCardapio(VariacaoCardapio variacaoCardapio) {
        return this.variacaoCardapioRepository.save(variacaoCardapio);
    }

    public VariacaoCardapio alterarVariacaoCardapio(UUID id, VariacaoCardapio variacaoCardapio) {
        VariacaoCardapio variacaoCardapioVariacaoCardapioAtualizade = this.buscarVariacaoCardapioPorId(id);
        variacaoCardapioVariacaoCardapioAtualizade.atualiza(variacaoCardapio);
        return this.variacaoCardapioRepository.save(variacaoCardapioVariacaoCardapioAtualizade);
    }

    public void removerVariacaoCardapio(UUID id) {
        VariacaoCardapio variacaoCardapio = this.buscarVariacaoCardapioPorId(id);
        this.variacaoCardapioRepository.delete(variacaoCardapio);
    }
}
