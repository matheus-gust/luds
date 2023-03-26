package br.com.luds.Luds.solicitacaoinsumo.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class SolicitacaoInsumoNaoEncontradaException extends NotFoundException {

    public SolicitacaoInsumoNaoEncontradaException() {
        super("Não foi possível encontrar a Solicitação");
    }

    public SolicitacaoInsumoNaoEncontradaException(String msg) {
        super(msg);
    }
}
