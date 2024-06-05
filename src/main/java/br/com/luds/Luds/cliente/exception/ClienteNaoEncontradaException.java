package br.com.luds.Luds.cliente.exception;

import br.com.luds.Luds.exception_handler.exception.NotFoundException;

public class ClienteNaoEncontradaException extends NotFoundException {
    public ClienteNaoEncontradaException() {
        super("Não foi possível encontrar o Cliente");
    }

    public ClienteNaoEncontradaException(String msg) {
        super(msg);
    }
}
