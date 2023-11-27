package br.com.luds.Luds.fornecedor.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.fornecedor.application.FornecedorApplication;
import br.com.luds.Luds.fornecedor.model.dto.FornecedorDTO;
import br.com.luds.Luds.fornecedor.model.form.FornecedorForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("fornecedor")
@AllArgsConstructor
public class FornecedorController {

    private final FornecedorApplication fornecedorApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<FornecedorDTO>> listarFornecedors(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.fornecedorApplication.listarFornecedors(pageRequest));
    }

    @GetMapping(path = "/{idFornecedor}")
    public ResponseEntity<FornecedorDTO> buscarFornecedorPorId(@PathVariable UUID idFornecedor) {
        return ResponseEntity.ok(this.fornecedorApplication.buscarFornecedorPorId(idFornecedor));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<FornecedorDTO> inserirFornecedors(@RequestBody FornecedorForm fornecedorForm) {
        return ResponseEntity.ok(this.fornecedorApplication.inserirFornecedor(fornecedorForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<FornecedorDTO> alterarFornecedors(@PathVariable UUID id, @RequestBody FornecedorForm fornecedorForm) {
        return ResponseEntity.ok(this.fornecedorApplication.alterarFornecedor(id, fornecedorForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<FornecedorDTO> removerFornecedor(@PathVariable UUID id) {
        this.fornecedorApplication.removerFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
