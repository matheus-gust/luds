package br.com.luds.Luds.tipopagamento.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class TipoPagamentoNaoEncontradaException extends NotFoundException {
    public TipoPagamentoNaoEncontradaException() {
        super("Não foi possível encontrar a Tipo Pagamento");
    }

    public TipoPagamentoNaoEncontradaException(String msg) {
        super(msg);
    }
}
