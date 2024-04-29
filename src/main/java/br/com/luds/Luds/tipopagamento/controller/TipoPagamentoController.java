package br.com.luds.Luds.tipopagamento.controller;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.tipopagamento.application.TipoPagamentoApplication;
import br.com.luds.Luds.tipopagamento.model.dto.TipoPagamentoDTO;
import br.com.luds.Luds.tipopagamento.model.form.TipoPagamentoForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("tipo-pagamento")
@AllArgsConstructor
public class TipoPagamentoController {

    private final TipoPagamentoApplication tipoPagamentoApplication;

    @GetMapping
    public ResponseEntity<ApiCollectionResponse<TipoPagamentoDTO>> listarTipoPagamentos(@Valid ApiPageRequest pageRequest) {
        return ResponseEntity.ok(this.tipoPagamentoApplication.listarTipoPagamentos(pageRequest));
    }

    @GetMapping(path = "/{idTipoPagamento}")
    public ResponseEntity<TipoPagamentoDTO> buscarTipoPagamentoPorId(@PathVariable UUID idTipoPagamento) {
        return ResponseEntity.ok(this.tipoPagamentoApplication.buscarTipoPagamentoPorId(idTipoPagamento));
    }

    @PostMapping(path = "inserir")
    public ResponseEntity<TipoPagamentoDTO> inserirTipoPagamentos(@RequestBody TipoPagamentoForm tipoPagamentoForm) {
        return ResponseEntity.ok(this.tipoPagamentoApplication.inserirTipoPagamento(tipoPagamentoForm));
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<TipoPagamentoDTO> alterarTipoPagamentos(@PathVariable UUID id, @RequestBody TipoPagamentoForm tipoPagamentoForm) {
        return ResponseEntity.ok(this.tipoPagamentoApplication.alterarTipoPagamento(id, tipoPagamentoForm));
    }

    @DeleteMapping(path = "remover/{id}")
    public ResponseEntity<TipoPagamentoDTO> removerTipoPagamento(@PathVariable UUID id) {
        this.tipoPagamentoApplication.removerTipoPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
