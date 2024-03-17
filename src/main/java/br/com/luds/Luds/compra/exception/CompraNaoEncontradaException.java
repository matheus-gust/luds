package br.com.luds.Luds.compra.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class CompraNaoEncontradaException extends NotFoundException {
    public CompraNaoEncontradaException() {
        super("Não foi possível encontrar o Venda");
    }

    public CompraNaoEncontradaException(String msg) {
        super(msg);
    }
}
