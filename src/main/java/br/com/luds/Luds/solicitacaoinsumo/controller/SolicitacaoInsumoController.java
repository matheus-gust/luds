package br.com.luds.Luds.solicitacaoinsumo.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.solicitacaoinsumo.application.SolicitacaoInsumoApplication;
import br.com.luds.Luds.solicitacaoinsumo.model.dto.SolicitacaoInsumoDTO;
import br.com.luds.Luds.solicitacaoinsumo.model.form.SolicitacaoInsumoForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("solicitacao-insumo")
@AllArgsConstructor
public class SolicitacaoInsumoController {

    private final SolicitacaoInsumoApplication solicitacaoInsumoApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<SolicitacaoInsumoDTO>> listarSolicitacaoInsumos(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.solicitacaoInsumoApplication.listarSolicitacaoInsumos(pageRequest));
    }

    @GetMapping(path = "buscar/{idSolicitacaoInsumo}")
    public ResponseEntity<SolicitacaoInsumoDTO> listarSolicitacaoInsumos(@PathVariable UUID idSolicitacaoInsumo) {
        return ResponseEntity.ok(this.solicitacaoInsumoApplication.buscarSolicitacaoInsumoPorId(idSolicitacaoInsumo));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<SolicitacaoInsumoDTO> inserirSolicitacaoInsumos(@RequestBody SolicitacaoInsumoForm solicitacaoInsumoForm) {
        return ResponseEntity.ok(this.solicitacaoInsumoApplication.inserirSolicitacaoInsumo(solicitacaoInsumoForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<SolicitacaoInsumoDTO> alterarSolicitacaoInsumos(@PathVariable UUID id, @RequestBody SolicitacaoInsumoForm solicitacaoInsumoForm) {
        return ResponseEntity.ok(this.solicitacaoInsumoApplication.alterarSolicitacaoInsumo(id, solicitacaoInsumoForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<SolicitacaoInsumoDTO> removerSolicitacaoInsumo(@PathVariable UUID id) {
        this.solicitacaoInsumoApplication.removerSolicitacaoInsumo(id);
        return ResponseEntity.noContent().build();
    }
}
