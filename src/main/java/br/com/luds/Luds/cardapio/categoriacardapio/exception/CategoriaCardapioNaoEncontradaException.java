package br.com.luds.Luds.cardapio.categoriacardapio.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class CategoriaCardapioNaoEncontradaException extends NotFoundException {
    public CategoriaCardapioNaoEncontradaException() {
        super("Não foi possível encontrar o CategoriaCardapio");
    }

    public CategoriaCardapioNaoEncontradaException(String msg) {
        super(msg);
    }
}
