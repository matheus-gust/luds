package br.com.luds.Luds.formapagamento.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.formapagamento.application.FormaPagamentoApplication;
import br.com.luds.Luds.formapagamento.model.dto.FormaPagamentoDTO;
import br.com.luds.Luds.formapagamento.model.form.FormaPagamentoForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("forma-pagamento")
@AllArgsConstructor
public class FormaPagamentoController {

    private final FormaPagamentoApplication formaPagamentoApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<FormaPagamentoDTO>> listarFormaPagamentos(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.formaPagamentoApplication.listarFormaPagamentos(pageRequest));
    }

    @GetMapping(path = "/{idFormaPagamento}")
    public ResponseEntity<FormaPagamentoDTO> buscarFormaPagamentoPorId(@PathVariable UUID idFormaPagamento) {
        return ResponseEntity.ok(this.formaPagamentoApplication.buscarFormaPagamentoPorId(idFormaPagamento));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<FormaPagamentoDTO> inserirFormaPagamentos(@Valid @RequestBody FormaPagamentoForm formaPagamentoForm) {
        return ResponseEntity.ok(this.formaPagamentoApplication.inserirFormaPagamento(formaPagamentoForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<FormaPagamentoDTO> alterarFormaPagamentos(@PathVariable UUID id, @Valid @RequestBody FormaPagamentoForm formaPagamentoForm) {
        return ResponseEntity.ok(this.formaPagamentoApplication.alterarFormaPagamento(id, formaPagamentoForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<FormaPagamentoDTO> removerFormaPagamento(@PathVariable UUID id) {
        this.formaPagamentoApplication.removerFormaPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
