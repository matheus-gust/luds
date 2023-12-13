package br.com.luds.Luds.venda.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class VendaNaoEncontradaException extends NotFoundException {
    public VendaNaoEncontradaException() {
        super("Não foi possível encontrar o Venda");
    }

    public VendaNaoEncontradaException(String msg) {
        super(msg);
    }
}
