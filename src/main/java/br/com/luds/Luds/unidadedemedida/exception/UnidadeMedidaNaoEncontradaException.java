package br.com.luds.Luds.unidadedemedida.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class UnidadeMedidaNaoEncontradaException extends NotFoundException {
    public UnidadeMedidaNaoEncontradaException() {
        super("Não foi possível encontrar a Unidade de Medida");
    }

    public UnidadeMedidaNaoEncontradaException(String msg) {
        super(msg);
    }
}
