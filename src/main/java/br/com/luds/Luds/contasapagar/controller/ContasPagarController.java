package br.com.luds.Luds.contasapagar.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.contasapagar.application.ContasPagarApplication;
import br.com.luds.Luds.contasapagar.model.dto.ContasPagarDTO;
import br.com.luds.Luds.contasapagar.model.form.ContasPagarForm;
import br.com.luds.Luds.contasapagar.model.form.MarcaContaPagoForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("conta-pagar")
@AllArgsConstructor
public class ContasPagarController {

    private final ContasPagarApplication contasPagarApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<ContasPagarDTO>> listarContasPagars(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.contasPagarApplication.listarContasPagars(pageRequest));
    }

    @GetMapping(path = "/{idContasPagar}")
    public ResponseEntity<ContasPagarDTO> buscarContasPagarPorId(@PathVariable UUID idContasPagar) {
        return ResponseEntity.ok(this.contasPagarApplication.buscarContasPagarPorId(idContasPagar));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<ContasPagarDTO> inserirContasPagars(@RequestBody ContasPagarForm contasPagarForm) {
        return ResponseEntity.ok(this.contasPagarApplication.inserirContasPagar(contasPagarForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<ContasPagarDTO> alterarContasPagars(@PathVariable UUID id, @RequestBody ContasPagarForm contasPagarForm) {
        return ResponseEntity.ok(this.contasPagarApplication.alterarContasPagar(id, contasPagarForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<ContasPagarDTO> removerContasPagar(@PathVariable UUID id) {
        this.contasPagarApplication.removerContasPagar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(path = "marca-pago/{id}")
    public ResponseEntity<Void> marcaPago(@PathVariable UUID id, @Valid @RequestBody MarcaContaPagoForm marcaContaPagoForm) {
        this.contasPagarApplication.marcaContaPago(id, marcaContaPagoForm);
        return ResponseEntity.ok().build();
    }
}
