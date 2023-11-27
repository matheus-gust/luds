package br.com.luds.Luds.fornecedor.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class FornecedorNaoEncontradaException extends NotFoundException {
    public FornecedorNaoEncontradaException() {
        super("Não foi possível encontrar o Fornecedor");
    }

    public FornecedorNaoEncontradaException(String msg) {
        super(msg);
    }
}
