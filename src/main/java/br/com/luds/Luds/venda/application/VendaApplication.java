package br.com.luds.Luds.venda.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.venda.model.Parte;
import br.com.luds.Luds.venda.model.assembler.VendaAssembler;
import br.com.luds.Luds.venda.model.dto.VendaDTO;
import br.com.luds.Luds.venda.model.form.ParteIn;
import br.com.luds.Luds.venda.model.form.VendaForm;
import br.com.luds.Luds.venda.model.form.VendaItemCardapioIn;
import br.com.luds.Luds.venda.service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VendaApplication {

    private final VendaService vendaService;
    private final VendaAssembler vendaAssembler;

    public ApiCollectionResponse<VendaDTO> listarVendas(ApiPageRequest pageRequest) {
        Page pageVenda = this.vendaService.listarVendas(pageRequest);
        return vendaAssembler.assembleManyDTO(pageVenda.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageVenda.hasNext());
    }

    public VendaDTO buscarVendaPorId(UUID id) {
        return this.vendaAssembler.assembleDTO(this.vendaService.buscarVendaPorId(id));
    }

    public VendaDTO inserirVenda(VendaForm venda) {
        List<ParteIn> partes = venda.getPartes();
        return this.vendaAssembler.assembleDTO(
                this.vendaService.inserirVenda(this.vendaAssembler.assembleEntity(venda), partes
                        ));
    }

    public VendaDTO alterarVenda(UUID id, VendaForm venda) {
        List<ParteIn> partes = venda.getPartes();
        return this.vendaAssembler.assembleDTO(this.vendaService.alterarVenda(id, this.vendaAssembler.assembleEntity(venda), partes));
    }

    public void removerVenda(UUID id) {
        this.vendaService.removerVenda(id);
    }
}
