package br.com.luds.Luds.cardapio.adicionalcardapio.application;

import br.com.luds.Luds.cardapio.adicionalcardapio.model.assembler.AdicionalCardapioAssembler;
import br.com.luds.Luds.cardapio.adicionalcardapio.model.form.dto.AdicionalCardapioDTO;
import br.com.luds.Luds.cardapio.adicionalcardapio.model.form.AdicionalCardapioForm;
import br.com.luds.Luds.cardapio.adicionalcardapio.service.AdicionalCardapioService;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AdicionalCardapioApplication {

    private final AdicionalCardapioService adicionalCardapioService;
    private final AdicionalCardapioAssembler adicionalCardapioAssembler;

    public ApiCollectionResponse<AdicionalCardapioDTO> listarAdicionalCardapios(ApiPageRequest pageRequest) {
        Page pageAdicionalCardapio = this.adicionalCardapioService.listarAdicionalCardapios(pageRequest);
        return adicionalCardapioAssembler.assembleManyDTO(pageAdicionalCardapio.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageAdicionalCardapio.hasNext());
    }

    public AdicionalCardapioDTO buscarAdicionalCardapioPorId(UUID id) {
        return this.adicionalCardapioAssembler.assembleDTO(this.adicionalCardapioService.buscarAdicionalCardapioPorId(id));
    }

    public AdicionalCardapioDTO inserirAdicionalCardapio(AdicionalCardapioForm adicionalCardapio) {
        return this.adicionalCardapioAssembler.assembleDTO(this.adicionalCardapioService.inserirAdicionalCardapio(this.adicionalCardapioAssembler.assembleEntity(adicionalCardapio)));
    }

    public AdicionalCardapioDTO alterarAdicionalCardapio(UUID id, AdicionalCardapioForm adicionalCardapio) {
        return this.adicionalCardapioAssembler.assembleDTO(this.adicionalCardapioService.alterarAdicionalCardapio(id, this.adicionalCardapioAssembler.assembleEntity(adicionalCardapio)));
    }

    public void removerAdicionalCardapio(UUID id) {
        this.adicionalCardapioService.removerAdicionalCardapio(id);
    }
}
