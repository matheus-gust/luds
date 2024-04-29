package br.com.luds.Luds.venda.service;

import br.com.luds.Luds.cardapio.itemcardapio.repository.ItemCardapioVariacaoRepository;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.venda.exception.VendaNaoEncontradaException;
import br.com.luds.Luds.venda.model.Venda;
import br.com.luds.Luds.venda.model.form.ParteIn;
import br.com.luds.Luds.venda.model.form.VendaItemCardapioIn;
import br.com.luds.Luds.venda.repository.ParteRepository;
import br.com.luds.Luds.venda.repository.VendaItemCardapioRepository;
import br.com.luds.Luds.venda.repository.VendaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final VendaItemCardapioRepository vendaItemCardapioRepository;
    private final ParteService parteService;
    private final ParteRepository parteRepository;

    public Venda buscarVendaPorId(UUID id) {
        return this.vendaRepository.findById(id).orElseThrow(() -> new VendaNaoEncontradaException());
    }

    public Page<Venda> listarVendas(ApiPageRequest pageRequest) {
        return this.vendaRepository.findAllOrderedByDataDesc(pageRequest.setPage());
    }
    @Transactional
    public Venda inserirVenda(Venda venda, List<ParteIn> partes) {
        if(!partes.isEmpty()) {
            venda.setPartes(this.parteService.deltaDeitens(partes, venda));
        }
        return this.vendaRepository.save(venda);
    }

    @Transactional
    public Venda alterarVenda(UUID id, Venda venda, List<ParteIn> partes) {
        Venda vendaVendaAtualizade = this.buscarVendaPorId(id);
        if(!vendaVendaAtualizade.getPartes().isEmpty() || !partes.isEmpty()) {
            vendaVendaAtualizade.setPartes(this.parteService.deltaDeitens(partes, vendaVendaAtualizade));
        }
        vendaVendaAtualizade.atualiza(venda);
        return this.vendaRepository.save(vendaVendaAtualizade);
    }
    @Transactional
    public void removerVenda(UUID id) {
        Venda venda = this.buscarVendaPorId(id);
        this.vendaRepository.delete(venda);
    }
}
