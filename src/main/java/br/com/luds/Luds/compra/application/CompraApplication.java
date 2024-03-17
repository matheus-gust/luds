package br.com.luds.Luds.compra.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.compra.model.assembler.CompraAssembler;
import br.com.luds.Luds.compra.model.dto.CompraDTO;
import br.com.luds.Luds.compra.model.form.CompraForm;
import br.com.luds.Luds.compra.model.form.CompraInsumoIn;
import br.com.luds.Luds.compra.service.CompraService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompraApplication {

    private final CompraService compraService;
    private final CompraAssembler compraAssembler;

    public ApiCollectionResponse<CompraDTO> listarCompras(ApiPageRequest pageRequest) {
        Page pageCompra = this.compraService.listarCompras(pageRequest);
        return compraAssembler.assembleManyDTO(pageCompra.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageCompra.hasNext());
    }

    public CompraDTO buscarCompraPorId(UUID id) {
        return this.compraAssembler.assembleDTO(this.compraService.buscarCompraPorId(id));
    }

    public CompraDTO inserirCompra(CompraForm compra) {
        List<CompraInsumoIn> itens = compra.getItens();
        return this.compraAssembler.assembleDTO(
                this.compraService.inserirCompra(this.compraAssembler.assembleEntity(compra), itens
                        ));
    }

    public CompraDTO alterarCompra(UUID id, CompraForm compra) {
        List<CompraInsumoIn> itens = compra.getItens();
        return this.compraAssembler.assembleDTO(this.compraService.alterarCompra(id, this.compraAssembler.assembleEntity(compra), itens));
    }

    public void removerCompra(UUID id) {
        this.compraService.removerCompra(id);
    }
}
