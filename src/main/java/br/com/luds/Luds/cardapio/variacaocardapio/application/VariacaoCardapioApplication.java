package br.com.luds.Luds.cardapio.variacaocardapio.application;

import br.com.luds.Luds.cardapio.variacaocardapio.model.assembler.VariacaoCardapioAssembler;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.VariacaoCardapioForm;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.dto.VariacaoCardapioDTO;
import br.com.luds.Luds.cardapio.variacaocardapio.service.VariacaoCardapioService;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class VariacaoCardapioApplication {

    private final VariacaoCardapioService variacaoCardapioService;
    private final VariacaoCardapioAssembler variacaoCardapioAssembler;

    public ApiCollectionResponse<VariacaoCardapioDTO> listarVariacaoCardapios(ApiPageRequest pageRequest) {
        Page pageVariacaoCardapio = this.variacaoCardapioService.listarVariacaoCardapios(pageRequest);
        return variacaoCardapioAssembler.assembleManyDTO(pageVariacaoCardapio.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageVariacaoCardapio.hasNext());
    }

    public VariacaoCardapioDTO buscarVariacaoCardapioPorId(UUID id) {
        return this.variacaoCardapioAssembler.assembleDTO(this.variacaoCardapioService.buscarVariacaoCardapioPorId(id));
    }

    public VariacaoCardapioDTO inserirVariacaoCardapio(VariacaoCardapioForm variacaoCardapio) {
        return this.variacaoCardapioAssembler.assembleDTO(this.variacaoCardapioService.inserirVariacaoCardapio(this.variacaoCardapioAssembler.assembleEntity(variacaoCardapio)));
    }

    public VariacaoCardapioDTO alterarVariacaoCardapio(UUID id, VariacaoCardapioForm variacaoCardapio) {
        return this.variacaoCardapioAssembler.assembleDTO(this.variacaoCardapioService.alterarVariacaoCardapio(id, this.variacaoCardapioAssembler.assembleEntity(variacaoCardapio)));
    }

    public void removerVariacaoCardapio(UUID id) {
        this.variacaoCardapioService.removerVariacaoCardapio(id);
    }
}
