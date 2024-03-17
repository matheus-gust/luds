package br.com.luds.Luds.compra.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.compra.application.CompraApplication;
import br.com.luds.Luds.compra.model.dto.CompraDTO;
import br.com.luds.Luds.compra.model.form.CompraForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("compra")
@AllArgsConstructor
public class CompraController {

    private final CompraApplication vendaApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<CompraDTO>> listarCompras(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.vendaApplication.listarCompras(pageRequest));
    }

    @GetMapping(path = "/{idCompra}")
    public ResponseEntity<CompraDTO> buscarCompraPorId(@PathVariable UUID idCompra) {
        return ResponseEntity.ok(this.vendaApplication.buscarCompraPorId(idCompra));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<CompraDTO> inserirCompras(@RequestBody CompraForm vendaForm) {
        return ResponseEntity.ok(this.vendaApplication.inserirCompra(vendaForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<CompraDTO> alterarCompras(@PathVariable UUID id, @RequestBody CompraForm vendaForm) {
        return ResponseEntity.ok(this.vendaApplication.alterarCompra(id, vendaForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<CompraDTO> removerCompra(@PathVariable UUID id) {
        this.vendaApplication.removerCompra(id);
        return ResponseEntity.noContent().build();
    }
}
