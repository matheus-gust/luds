package br.com.luds.Luds.cardapio.variacaocardapio.controller;

import br.com.luds.Luds.cardapio.variacaocardapio.application.VariacaoCardapioApplication;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.VariacaoCardapioForm;
import br.com.luds.Luds.cardapio.variacaocardapio.model.form.dto.VariacaoCardapioDTO;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("variedade-cardapio")
@AllArgsConstructor
public class VariacaoCardapioController {

    private final VariacaoCardapioApplication variacaoCardapioApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<VariacaoCardapioDTO>> listarVariacaoCardapios(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.variacaoCardapioApplication.listarVariacaoCardapios(pageRequest));
    }

    @GetMapping(path = "/{idVariacaoCardapio}")
    public ResponseEntity<VariacaoCardapioDTO> buscarVariacaoCardapioPorId(@PathVariable UUID idVariacaoCardapio) {
        return ResponseEntity.ok(this.variacaoCardapioApplication.buscarVariacaoCardapioPorId(idVariacaoCardapio));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<VariacaoCardapioDTO> inserirVariacaoCardapios(@RequestBody VariacaoCardapioForm variacaoCardapioForm) {
        return ResponseEntity.ok(this.variacaoCardapioApplication.inserirVariacaoCardapio(variacaoCardapioForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<VariacaoCardapioDTO> alterarVariacaoCardapios(@PathVariable UUID id, @RequestBody VariacaoCardapioForm variacaoCardapioForm) {
        return ResponseEntity.ok(this.variacaoCardapioApplication.alterarVariacaoCardapio(id, variacaoCardapioForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<VariacaoCardapioDTO> removerVariacaoCardapio(@PathVariable UUID id) {
        this.variacaoCardapioApplication.removerVariacaoCardapio(id);
        return ResponseEntity.noContent().build();
    }
}
