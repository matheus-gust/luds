package br.com.luds.Luds.categoria.controller;

import br.com.luds.Luds.categoria.application.CategoriaApplication;
import br.com.luds.Luds.categoria.model.dto.CategoriaDTO;
import br.com.luds.Luds.categoria.model.form.CategoriaForm;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("categoria")
@AllArgsConstructor
public class CategoriaController {

    private final CategoriaApplication categoriaApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<CategoriaDTO>> listarCategorias(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.categoriaApplication.listarCategorias(pageRequest));
    }

    @GetMapping(path = "/{idCategoria}")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable UUID idCategoria) {
        return ResponseEntity.ok(this.categoriaApplication.buscarCategoriaPorId(idCategoria));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<CategoriaDTO> inserirCategorias(@RequestBody CategoriaForm categoriaForm) {
        return ResponseEntity.ok(this.categoriaApplication.inserirCategoria(categoriaForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<CategoriaDTO> alterarCategorias(@PathVariable UUID id, @RequestBody CategoriaForm categoriaForm) {
        return ResponseEntity.ok(this.categoriaApplication.alterarCategoria(id, categoriaForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<CategoriaDTO> removerCategoria(@PathVariable UUID id) {
        this.categoriaApplication.removerCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
