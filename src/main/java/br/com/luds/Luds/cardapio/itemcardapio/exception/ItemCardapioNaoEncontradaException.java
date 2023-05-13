package br.com.luds.Luds.cardapio.itemcardapio.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class ItemCardapioNaoEncontradaException extends NotFoundException {
    public ItemCardapioNaoEncontradaException() {
        super("Não foi possível encontrar o ItemCardapio");
    }

    public ItemCardapioNaoEncontradaException(String msg) {
        super(msg);
    }
}
