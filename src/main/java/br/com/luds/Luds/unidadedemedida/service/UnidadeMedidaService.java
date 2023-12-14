package br.com.luds.Luds.unidadedemedida.service;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.unidadedemedida.exception.UnidadeMedidaNaoEncontradaException;
import br.com.luds.Luds.unidadedemedida.model.UnidadeMedida;
import br.com.luds.Luds.unidadedemedida.repository.UnidadeMedidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UnidadeMedidaService {

    private final UnidadeMedidaRepository unidadeMedidaRepository;

    public UnidadeMedida buscarUnidadeMedidaPorId(UUID id) {
        if(Objects.isNull(id)) {
            throw new UnidadeMedidaNaoEncontradaException();
        }
        return this.unidadeMedidaRepository.findById(id).orElseThrow(() -> new UnidadeMedidaNaoEncontradaException());
    }

    public Page<UnidadeMedida> listarUnidadeMedidas(ApiPageRequest pageRequest) {
        return this.unidadeMedidaRepository.findAll(pageRequest.setPage());
    }

    public UnidadeMedida inserirUnidadeMedida(UnidadeMedida unidadeMedida) {
        return this.unidadeMedidaRepository.save(unidadeMedida);
    }

    public UnidadeMedida alterarUnidadeMedida(UUID id, UnidadeMedida unidadeMedida) {
        UnidadeMedida unidadeMedidaUnidadeMedidaAtualizade = this.buscarUnidadeMedidaPorId(id);
        unidadeMedidaUnidadeMedidaAtualizade.atualiza(unidadeMedida);
        return this.unidadeMedidaRepository.save(unidadeMedidaUnidadeMedidaAtualizade);
    }

    public void removerUnidadeMedida(UUID id) {
        UnidadeMedida unidadeMedida = this.buscarUnidadeMedidaPorId(id);
        this.unidadeMedidaRepository.delete(unidadeMedida);
    }
}
