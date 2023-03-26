package br.com.luds.Luds.unidade.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class UnidadeNaoEncontradaException extends NotFoundException {

    public UnidadeNaoEncontradaException() {
        super("Não foi possível encontrar a Unidade");
    }

    public UnidadeNaoEncontradaException(String msg) {
        super(msg);
    }
}
