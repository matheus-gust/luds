package br.com.luds.Luds.categoria.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class CategoriaNaoEncontradaException extends NotFoundException {
    public CategoriaNaoEncontradaException() {
        super("Não foi possível encontrar o Categoria");
    }

    public CategoriaNaoEncontradaException(String msg) {
        super(msg);
    }
}
