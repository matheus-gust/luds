package br.com.luds.Luds.cardapio.categoriacardapio.controller;

import br.com.luds.Luds.cardapio.categoriacardapio.application.CategoriaCardapioApplication;
import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import br.com.luds.Luds.cardapio.categoriacardapio.model.form.CategoriaCardapioForm;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("categoria-cardapio")
@AllArgsConstructor
public class CategoriaCardapioController {

    private final CategoriaCardapioApplication categoriaCardapioApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<CategoriaCardapioDTO>> listarCategoriaCardapios(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.categoriaCardapioApplication.listarCategoriaCardapios(pageRequest));
    }

    @GetMapping(path = "/{idCategoriaCardapio}")
    public ResponseEntity<CategoriaCardapioDTO> buscarCategoriaCardapioPorId(@PathVariable UUID idCategoriaCardapio) {
        return ResponseEntity.ok(this.categoriaCardapioApplication.buscarCategoriaCardapioPorId(idCategoriaCardapio));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<CategoriaCardapioDTO> inserirCategoriaCardapios(@RequestBody CategoriaCardapioForm categoriaCardapioForm) {
        return ResponseEntity.ok(this.categoriaCardapioApplication.inserirCategoriaCardapio(categoriaCardapioForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<CategoriaCardapioDTO> alterarCategoriaCardapios(@PathVariable UUID id, @RequestBody CategoriaCardapioForm categoriaCardapioForm) {
        return ResponseEntity.ok(this.categoriaCardapioApplication.alterarCategoriaCardapio(id, categoriaCardapioForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<CategoriaCardapioDTO> removerCategoriaCardapio(@PathVariable UUID id) {
        this.categoriaCardapioApplication.removerCategoriaCardapio(id);
        return ResponseEntity.noContent().build();
    }
}
