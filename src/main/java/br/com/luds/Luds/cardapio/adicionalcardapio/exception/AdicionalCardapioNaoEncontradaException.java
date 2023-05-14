package br.com.luds.Luds.cardapio.adicionalcardapio.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class AdicionalCardapioNaoEncontradaException extends NotFoundException {
    public AdicionalCardapioNaoEncontradaException() {
        super("Não foi possível encontrar o AdicionalCardapio");
    }

    public AdicionalCardapioNaoEncontradaException(String msg) {
        super(msg);
    }
}
