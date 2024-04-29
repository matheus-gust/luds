package br.com.luds.Luds.insumo.service;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.insumo.exception.InsumoNaoEncontradaException;
import br.com.luds.Luds.insumo.model.Insumo;
import br.com.luds.Luds.insumo.repository.InsumoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class InsumoService {

    private final InsumoRepository insumoRepository;

    public Insumo buscarInsumoPorId(UUID id) {
        return this.insumoRepository.findById(id).orElseThrow(() -> new InsumoNaoEncontradaException());
    }

    public Page<Insumo> listarInsumos(ApiPageRequest pageRequest) {
        return this.insumoRepository.findAllOrderedByCodigoAsc(pageRequest.setPage());
    }

    public Insumo inserirInsumo(Insumo insumo) {
        return this.insumoRepository.save(insumo);
    }

    public Insumo alterarInsumo(UUID id, Insumo insumo) {
        Insumo insumoInsumoAtualizade = this.buscarInsumoPorId(id);
        insumoInsumoAtualizade.atualiza(insumo);
        return this.insumoRepository.save(insumoInsumoAtualizade);
    }

    public void removerInsumo(UUID id) {
        Insumo insumo = this.buscarInsumoPorId(id);
        this.insumoRepository.delete(insumo);
    }
}
