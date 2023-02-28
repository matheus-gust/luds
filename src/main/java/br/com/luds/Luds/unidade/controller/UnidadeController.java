package br.com.luds.Luds.unidade.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.unidade.application.UnidadeApplication;
import br.com.luds.Luds.unidade.model.dto.UnidadeDTO;
import br.com.luds.Luds.unidade.model.form.UnidadeForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("unidade")
@AllArgsConstructor
public class UnidadeController {

    private final UnidadeApplication unidadeApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<UnidadeDTO>> listarUnidades(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.unidadeApplication.listarUnidades(pageRequest));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<UnidadeDTO> inserirUnidades(@RequestBody UnidadeForm unidadeForm) {
        return ResponseEntity.ok(this.unidadeApplication.inserirUnidade(unidadeForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<UnidadeDTO> alterarUnidades(@PathVariable UUID id, @RequestBody UnidadeForm unidadeForm) {
        return ResponseEntity.ok(this.unidadeApplication.alterarUnidade(id, unidadeForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<UnidadeDTO> removerUnidade(@PathVariable UUID id) {
        this.unidadeApplication.removerUnidade(id);
        return ResponseEntity.noContent().build();
    }
}
