package br.com.luds.Luds.venda.service;

import br.com.luds.Luds.cardapio.itemcardapio.repository.ItemCardapioVariacaoRepository;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.venda.exception.VendaNaoEncontradaException;
import br.com.luds.Luds.venda.model.Venda;
import br.com.luds.Luds.venda.model.form.VendaItemCardapioIn;
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
    private final VendaItemCardapioService vendaItemCardapioService;

    public Venda buscarVendaPorId(UUID id) {
        return this.vendaRepository.findById(id).orElseThrow(() -> new VendaNaoEncontradaException());
    }

    public Page<Venda> listarVendas(ApiPageRequest pageRequest) {
        return this.vendaRepository.findAll(pageRequest.setPage());
    }
    @Transactional
    public Venda inserirVenda(Venda venda, List<VendaItemCardapioIn> itens) {
        Venda novaVenda = this.vendaRepository.save(venda);
        if(!itens.isEmpty()) {
            novaVenda.setItens(this.vendaItemCardapioService.deltaDeitens(itens, novaVenda));
        }
        this.vendaItemCardapioRepository.saveAll(novaVenda.getItens());
        return this.vendaRepository.save(venda);
    }

    @Transactional
    public Venda alterarVenda(UUID id, Venda venda, List<VendaItemCardapioIn> itens) {
        Venda vendaVendaAtualizade = this.buscarVendaPorId(id);
        if(!vendaVendaAtualizade.getItens().isEmpty() || !itens.isEmpty()) {
            vendaVendaAtualizade.setItens(this.vendaItemCardapioService.deltaDeitens(itens, vendaVendaAtualizade));
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
