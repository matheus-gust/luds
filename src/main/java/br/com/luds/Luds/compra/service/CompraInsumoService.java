package br.com.luds.Luds.compra.service;

import br.com.luds.Luds.compra.model.Compra;
import br.com.luds.Luds.compra.model.CompraInsumo;
import br.com.luds.Luds.compra.model.form.CompraInsumoIn;
import br.com.luds.Luds.compra.repository.CompraInsumoRepository;
import br.com.luds.Luds.insumo.exception.InsumoNaoEncontradaException;
import br.com.luds.Luds.insumo.model.Insumo;
import br.com.luds.Luds.insumo.service.InsumoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompraInsumoService {
    private final CompraInsumoRepository compraInsumoRepository;
    private final InsumoService insumoService;

    public List<CompraInsumo> deltaDeitens(List<CompraInsumoIn> itens, Compra compra) {
        List<CompraInsumo> antigosRelacionamentos = this.listarRelacoesPorIdItemEm(compra.getId());

        List<CompraInsumo> novosRelacionamentos = new ArrayList<>();
        itens.forEach(itemComp -> {
            if(Objects.isNull(itemComp.getInsumo()) && Objects.isNull(itemComp.getInsumo().getId())) {
                throw new InsumoNaoEncontradaException();
            }
            Insumo insumo = insumoService.buscarInsumoPorId(itemComp.getInsumo().getId());
            novosRelacionamentos.add(new CompraInsumo(null, compra, insumo, itemComp.getQuantidade(), itemComp.getDesconto(), itemComp.getValor()));
        });

        for (CompraInsumo item : antigosRelacionamentos) {
            this.compraInsumoRepository.delete(item);
        }
        return novosRelacionamentos;
    }

    public List<CompraInsumo> listarRelacoesPorIdItemEm(UUID id) {
        return this.compraInsumoRepository.findAllByCompraId(id);
    }
}
