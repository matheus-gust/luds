package br.com.luds.Luds.formapagamento.service;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.formapagamento.exception.FormaPagamentoNaoEncontradaException;
import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import br.com.luds.Luds.formapagamento.repository.FormaPagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FormaPagamentoService {

    private final FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamento buscarFormaPagamentoPorId(UUID id) {
        if(Objects.isNull(id)) {
            throw new FormaPagamentoNaoEncontradaException();
        }
        return this.formaPagamentoRepository.findById(id).orElseThrow(() -> new FormaPagamentoNaoEncontradaException());
    }

    public Page<FormaPagamento> listarFormaPagamentos(ApiPageRequest pageRequest) {
        return this.formaPagamentoRepository.findAllOrderedByNomeAsc(pageRequest.setPage());
    }

    public FormaPagamento inserirFormaPagamento(FormaPagamento formaPagamento) {
        return this.formaPagamentoRepository.save(formaPagamento);
    }

    public FormaPagamento alterarFormaPagamento(UUID id, FormaPagamento formaPagamento) {
        FormaPagamento formaPagamentoFormaPagamentoAtualizade = this.buscarFormaPagamentoPorId(id);
        formaPagamentoFormaPagamentoAtualizade.atualiza(formaPagamento);
        return this.formaPagamentoRepository.save(formaPagamentoFormaPagamentoAtualizade);
    }

    public void removerFormaPagamento(UUID id) {
        FormaPagamento formaPagamento = this.buscarFormaPagamentoPorId(id);
        this.formaPagamentoRepository.delete(formaPagamento);
    }
}
