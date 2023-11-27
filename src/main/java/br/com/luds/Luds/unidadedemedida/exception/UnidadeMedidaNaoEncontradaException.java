package br.com.luds.Luds.unidadedemedida.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class UnidadeMedidaNaoEncontradaException extends NotFoundException {
    public UnidadeMedidaNaoEncontradaException() {
        super("Não foi possível encontrar o UnidadeMedida");
    }

    public UnidadeMedidaNaoEncontradaException(String msg) {
        super(msg);
    }
}
