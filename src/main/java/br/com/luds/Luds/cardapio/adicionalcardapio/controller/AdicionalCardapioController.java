package br.com.luds.Luds.cardapio.adicionalcardapio.controller;

import br.com.luds.Luds.cardapio.adicionalcardapio.application.AdicionalCardapioApplication;
import br.com.luds.Luds.cardapio.adicionalcardapio.model.form.dto.AdicionalCardapioDTO;
import br.com.luds.Luds.cardapio.adicionalcardapio.model.form.AdicionalCardapioForm;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("adicional-cardapio")
@AllArgsConstructor
public class AdicionalCardapioController {

    private final AdicionalCardapioApplication adicionalCardapioApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<AdicionalCardapioDTO>> listarAdicionalCardapios(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.adicionalCardapioApplication.listarAdicionalCardapios(pageRequest));
    }

    @GetMapping(path = "/{idAdicionalCardapio}")
    public ResponseEntity<AdicionalCardapioDTO> buscarAdicionalCardapioPorId(@PathVariable UUID idAdicionalCardapio) {
        return ResponseEntity.ok(this.adicionalCardapioApplication.buscarAdicionalCardapioPorId(idAdicionalCardapio));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<AdicionalCardapioDTO> inserirAdicionalCardapios(@RequestBody AdicionalCardapioForm adicionalCardapioForm) {
        return ResponseEntity.ok(this.adicionalCardapioApplication.inserirAdicionalCardapio(adicionalCardapioForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<AdicionalCardapioDTO> alterarAdicionalCardapios(@PathVariable UUID id, @RequestBody AdicionalCardapioForm adicionalCardapioForm) {
        return ResponseEntity.ok(this.adicionalCardapioApplication.alterarAdicionalCardapio(id, adicionalCardapioForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<AdicionalCardapioDTO> removerAdicionalCardapio(@PathVariable UUID id) {
        this.adicionalCardapioApplication.removerAdicionalCardapio(id);
        return ResponseEntity.noContent().build();
    }
}
