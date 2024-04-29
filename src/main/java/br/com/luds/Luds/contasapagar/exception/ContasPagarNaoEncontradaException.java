package br.com.luds.Luds.contasapagar.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class ContasPagarNaoEncontradaException extends NotFoundException {
    public ContasPagarNaoEncontradaException() {
        super("Não foi possível encontrar a Unidade de Medida");
    }

    public ContasPagarNaoEncontradaException(String msg) {
        super(msg);
    }
}
