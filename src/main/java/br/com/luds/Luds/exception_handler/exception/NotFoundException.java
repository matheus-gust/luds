package br.com.luds.Luds.exception_handler.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {

    }

    public NotFoundException(String msg) {
        super(msg);
    }
}
