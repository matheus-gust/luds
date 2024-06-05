package br.com.luds.Luds.cliente.controller;

import br.com.luds.Luds.cliente.application.ClienteApplication;
import br.com.luds.Luds.cliente.model.dto.ClienteDTO;
import br.com.luds.Luds.cliente.model.form.ClienteForm;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteApplication clienteApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<ClienteDTO>> listarUnidadeMedidas(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.clienteApplication.listarUnidadeMedidas(pageRequest));
    }

    @GetMapping(path = "/{idUnidadeMedida}")
    public ResponseEntity<ClienteDTO> buscarUnidadeMedidaPorId(@PathVariable UUID idUnidadeMedida) {
        return ResponseEntity.ok(this.clienteApplication.buscarUnidadeMedidaPorId(idUnidadeMedida));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<ClienteDTO> inserirUnidadeMedidas(@RequestBody ClienteForm clienteForm) {
        return ResponseEntity.ok(this.clienteApplication.inserirUnidadeMedida(clienteForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<ClienteDTO> alterarUnidadeMedidas(@PathVariable UUID id, @RequestBody ClienteForm clienteForm) {
        return ResponseEntity.ok(this.clienteApplication.alterarUnidadeMedida(id, clienteForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<ClienteDTO> removerUnidadeMedida(@PathVariable UUID id) {
        this.clienteApplication.removerUnidadeMedida(id);
        return ResponseEntity.noContent().build();
    }
}
