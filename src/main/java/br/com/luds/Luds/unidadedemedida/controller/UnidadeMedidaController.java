package br.com.luds.Luds.unidadedemedida.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.unidadedemedida.application.UnidadeMedidaApplication;
import br.com.luds.Luds.unidadedemedida.model.dto.UnidadeMedidaDTO;
import br.com.luds.Luds.unidadedemedida.model.form.UnidadeMedidaForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("unidade-medida")
@AllArgsConstructor
public class UnidadeMedidaController {

    private final UnidadeMedidaApplication unidadeMedidaApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<UnidadeMedidaDTO>> listarUnidadeMedidas(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.unidadeMedidaApplication.listarUnidadeMedidas(pageRequest));
    }

    @GetMapping(path = "/{idUnidadeMedida}")
    public ResponseEntity<UnidadeMedidaDTO> buscarUnidadeMedidaPorId(@PathVariable UUID idUnidadeMedida) {
        return ResponseEntity.ok(this.unidadeMedidaApplication.buscarUnidadeMedidaPorId(idUnidadeMedida));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<UnidadeMedidaDTO> inserirUnidadeMedidas(@RequestBody UnidadeMedidaForm unidadeMedidaForm) {
        return ResponseEntity.ok(this.unidadeMedidaApplication.inserirUnidadeMedida(unidadeMedidaForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<UnidadeMedidaDTO> alterarUnidadeMedidas(@PathVariable UUID id, @RequestBody UnidadeMedidaForm unidadeMedidaForm) {
        return ResponseEntity.ok(this.unidadeMedidaApplication.alterarUnidadeMedida(id, unidadeMedidaForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<UnidadeMedidaDTO> removerUnidadeMedida(@PathVariable UUID id) {
        this.unidadeMedidaApplication.removerUnidadeMedida(id);
        return ResponseEntity.noContent().build();
    }
}
