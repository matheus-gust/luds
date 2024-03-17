package br.com.luds.Luds.cardapio.itemcardapio.controller;

import br.com.luds.Luds.cardapio.itemcardapio.application.ItemCardapioApplication;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.dto.ItemCardapioInfoDTO;
import br.com.luds.Luds.cardapio.itemcardapio.model.form.ItemCardapioForm;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("item-cardapio")
@AllArgsConstructor
public class ItemCardapioController {

    private final ItemCardapioApplication itemCardapioApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<ItemCardapioDTO>> listarItemCardapios(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.itemCardapioApplication.listarItemCardapios(pageRequest));
    }

    @GetMapping(path = "info")
    public ResponseEntity<ApiCollectionResponse<ItemCardapioInfoDTO>> listarItemCardapiosInfo(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.itemCardapioApplication.listarItemCardapiosInfo(pageRequest));
    }

    @GetMapping(path = "/{idItemCardapio}")
    public ResponseEntity<ItemCardapioDTO> buscarItemCardapioPorId(@PathVariable UUID idItemCardapio) {
        return ResponseEntity.ok(this.itemCardapioApplication.buscarItemCardapioPorId(idItemCardapio));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<ItemCardapioDTO> inserirItemCardapios(@Valid @RequestBody ItemCardapioForm itemCardapioForm) {
        return ResponseEntity.ok(this.itemCardapioApplication.inserirItemCardapio(itemCardapioForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<ItemCardapioDTO> alterarItemCardapios(@PathVariable UUID id, @RequestBody ItemCardapioForm itemCardapioForm) {
        return ResponseEntity.ok(this.itemCardapioApplication.alterarItemCardapio(id, itemCardapioForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<ItemCardapioDTO> removerItemCardapio(@PathVariable UUID id) {
        this.itemCardapioApplication.removerItemCardapio(id);
        return ResponseEntity.noContent().build();
    }
}
