package br.com.luds.Luds.formapagamento.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class FormaPagamentoNaoEncontradaException extends NotFoundException {
    public FormaPagamentoNaoEncontradaException() {
        super("Não foi possível encontrar a Unidade de Medida");
    }

    public FormaPagamentoNaoEncontradaException(String msg) {
        super(msg);
    }
}
