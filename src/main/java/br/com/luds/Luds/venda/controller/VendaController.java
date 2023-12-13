package br.com.luds.Luds.venda.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.venda.application.VendaApplication;
import br.com.luds.Luds.venda.model.dto.VendaDTO;
import br.com.luds.Luds.venda.model.form.VendaForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("venda")
@AllArgsConstructor
public class VendaController {

    private final VendaApplication vendaApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<VendaDTO>> listarVendas(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.vendaApplication.listarVendas(pageRequest));
    }

    @GetMapping(path = "/{idVenda}")
    public ResponseEntity<VendaDTO> buscarVendaPorId(@PathVariable UUID idVenda) {
        return ResponseEntity.ok(this.vendaApplication.buscarVendaPorId(idVenda));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<VendaDTO> inserirVendas(@RequestBody VendaForm vendaForm) {
        return ResponseEntity.ok(this.vendaApplication.inserirVenda(vendaForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<VendaDTO> alterarVendas(@PathVariable UUID id, @RequestBody VendaForm vendaForm) {
        return ResponseEntity.ok(this.vendaApplication.alterarVenda(id, vendaForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<VendaDTO> removerVenda(@PathVariable UUID id) {
        this.vendaApplication.removerVenda(id);
        return ResponseEntity.noContent().build();
    }
}
