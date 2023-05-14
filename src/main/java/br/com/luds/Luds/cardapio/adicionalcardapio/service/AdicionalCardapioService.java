package br.com.luds.Luds.cardapio.adicionalcardapio.service;

import br.com.luds.Luds.cardapio.adicionalcardapio.exception.AdicionalCardapioNaoEncontradaException;
import br.com.luds.Luds.cardapio.adicionalcardapio.model.AdicionalCardapio;
import br.com.luds.Luds.cardapio.adicionalcardapio.repository.AdicionalCardapioRepository;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AdicionalCardapioService {

    private final AdicionalCardapioRepository adicionalCardapioRepository;

    public AdicionalCardapio buscarAdicionalCardapioPorId(UUID id) {
        return this.adicionalCardapioRepository.findById(id).orElseThrow(() -> new AdicionalCardapioNaoEncontradaException());
    }

    public Page<AdicionalCardapio> listarAdicionalCardapios(ApiPageRequest pageRequest) {
        return this.adicionalCardapioRepository.findAll(pageRequest.setPage());
    }

    public AdicionalCardapio inserirAdicionalCardapio(AdicionalCardapio adicionalCardapio) {
        return this.adicionalCardapioRepository.save(adicionalCardapio);
    }

    public AdicionalCardapio alterarAdicionalCardapio(UUID id, AdicionalCardapio adicionalCardapio) {
        AdicionalCardapio adicionalCardapioAdicionalCardapioAtualizade = this.buscarAdicionalCardapioPorId(id);
        adicionalCardapioAdicionalCardapioAtualizade.atualiza(adicionalCardapio);
        return this.adicionalCardapioRepository.save(adicionalCardapioAdicionalCardapioAtualizade);
    }

    public void removerAdicionalCardapio(UUID id) {
        AdicionalCardapio adicionalCardapio = this.buscarAdicionalCardapioPorId(id);
        this.adicionalCardapioRepository.delete(adicionalCardapio);
    }
}
