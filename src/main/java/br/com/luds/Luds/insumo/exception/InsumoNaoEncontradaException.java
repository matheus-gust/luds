package br.com.luds.Luds.insumo.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class InsumoNaoEncontradaException extends NotFoundException {
    public InsumoNaoEncontradaException() {
        super("Não foi possível encontrar o Insumo");
    }

    public InsumoNaoEncontradaException(String msg) {
        super(msg);
    }
}
