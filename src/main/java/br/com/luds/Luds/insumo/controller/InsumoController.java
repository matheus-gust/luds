package br.com.luds.Luds.insumo.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.insumo.application.InsumoApplication;
import br.com.luds.Luds.insumo.model.dto.InsumoDTO;
import br.com.luds.Luds.insumo.model.form.InsumoForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("insumo")
@AllArgsConstructor
public class InsumoController {

    private final InsumoApplication insumoApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<InsumoDTO>> listarInsumos(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.insumoApplication.listarInsumos(pageRequest));
    }

    @GetMapping(path = "/{idInsumo}")
    public ResponseEntity<InsumoDTO> buscarInsumoPorId(@PathVariable UUID idInsumo) {
        return ResponseEntity.ok(this.insumoApplication.buscarInsumoPorId(idInsumo));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<InsumoDTO> inserirInsumos(@RequestBody InsumoForm insumoForm) {
        return ResponseEntity.ok(this.insumoApplication.inserirInsumo(insumoForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<InsumoDTO> alterarInsumos(@PathVariable UUID id, @RequestBody InsumoForm insumoForm) {
        return ResponseEntity.ok(this.insumoApplication.alterarInsumo(id, insumoForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<InsumoDTO> removerInsumo(@PathVariable UUID id) {
        this.insumoApplication.removerInsumo(id);
        return ResponseEntity.noContent().build();
    }
}
