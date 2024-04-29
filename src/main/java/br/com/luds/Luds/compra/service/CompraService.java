package br.com.luds.Luds.compra.service;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.compra.exception.CompraNaoEncontradaException;
import br.com.luds.Luds.compra.model.Compra;
import br.com.luds.Luds.compra.model.form.CompraInsumoIn;
import br.com.luds.Luds.compra.repository.CompraInsumoRepository;
import br.com.luds.Luds.compra.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final CompraInsumoRepository compraItemCardapioRepository;
    private final CompraInsumoService compraItemCardapioService;

    public Compra buscarCompraPorId(UUID id) {
        return this.compraRepository.findById(id).orElseThrow(() -> new CompraNaoEncontradaException());
    }

    public Page<Compra> listarCompras(ApiPageRequest pageRequest) {
        Page<Compra> compras = this.compraRepository.findAllOrderedByDataDesc(pageRequest.setPage());
        return compras;
    }
    @Transactional
    public Compra inserirCompra(Compra compra, List<CompraInsumoIn> itens) {
        Compra novaCompra = this.compraRepository.save(compra);
        if(!itens.isEmpty()) {
            novaCompra.setItens(this.compraItemCardapioService.deltaDeitens(itens, novaCompra));
        }
        this.compraItemCardapioRepository.saveAll(novaCompra.getItens());
        return this.compraRepository.save(compra);
    }

    @Transactional
    public Compra alterarCompra(UUID id, Compra compra, List<CompraInsumoIn> itens) {
        Compra compraCompraAtualizade = this.buscarCompraPorId(id);
        if(!compraCompraAtualizade.getItens().isEmpty() || !itens.isEmpty()) {
            compraCompraAtualizade.setItens(this.compraItemCardapioService.deltaDeitens(itens, compraCompraAtualizade));
        }
        compraCompraAtualizade.atualiza(compra);
        return this.compraRepository.save(compraCompraAtualizade);
    }
    @Transactional
    public void removerCompra(UUID id) {
        Compra compra = this.buscarCompraPorId(id);
        this.compraRepository.delete(compra);
    }
}
