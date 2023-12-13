package br.com.luds.Luds.venda.service;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.venda.exception.VendaNaoEncontradaException;
import br.com.luds.Luds.venda.model.Venda;
import br.com.luds.Luds.venda.repository.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;

    public Venda buscarVendaPorId(UUID id) {
        return this.vendaRepository.findById(id).orElseThrow(() -> new VendaNaoEncontradaException());
    }

    public Page<Venda> listarVendas(ApiPageRequest pageRequest) {
        return this.vendaRepository.findAll(pageRequest.setPage());
    }

    public Venda inserirVenda(Venda venda) {
        return this.vendaRepository.save(venda);
    }

    public Venda alterarVenda(UUID id, Venda venda) {
        Venda vendaVendaAtualizade = this.buscarVendaPorId(id);
        vendaVendaAtualizade.atualiza(venda);
        return this.vendaRepository.save(vendaVendaAtualizade);
    }

    public void removerVenda(UUID id) {
        Venda venda = this.buscarVendaPorId(id);
        this.vendaRepository.delete(venda);
    }
}
