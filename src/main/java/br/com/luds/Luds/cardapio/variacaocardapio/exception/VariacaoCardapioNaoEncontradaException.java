package br.com.luds.Luds.cardapio.variacaocardapio.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class VariacaoCardapioNaoEncontradaException extends NotFoundException {
    public VariacaoCardapioNaoEncontradaException() {
        super("Não foi possível encontrar a Variedade");
    }

    public VariacaoCardapioNaoEncontradaException(String msg) {
        super(msg);
    }
}
