package br.com.luds.Luds.exception_handler.resource;

import br.com.luds.Luds.exception_handler.exception.BlockedException;
import br.com.luds.Luds.exception_handler.exception.CodigoRepetidoException;
import br.com.luds.Luds.exception_handler.exception.IllegalArgumentException;
import br.com.luds.Luds.exception_handler.exception.NotFoundException;
import br.com.luds.Luds.exception_handler.model.ErroPadrao;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErroResource {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErroPadrao> objectNotFound(NotFoundException e, HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI(), true);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(CodigoRepetidoException.class)
    public ResponseEntity<ErroPadrao> objectNotFound(CodigoRepetidoException e, HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), "Numero repetido", e.getMessage(), request.getRequestURI(), true);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroPadrao> objectIllegal(IllegalArgumentException e, HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Não permitido", e.getMessage(), request.getRequestURI(), true);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(BlockedException.class)
    public ResponseEntity<ErroPadrao> objectIllegal(BlockedException e, HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), HttpStatus.LOCKED.value(), "Sem permissão", e.getMessage(), request.getRequestURI(), true);
        return ResponseEntity.status(HttpStatus.LOCKED).body(erro);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErroPadrao> objectIllegal(ConstraintViolationException e, HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Entidades já relacionadas", "Essa entidade já não pode ser excluida", request.getRequestURI(), true);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<ErroPadrao> objectIllegal(javax.validation.ConstraintViolationException e, HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Entidades já relacionadas", "Essa entidade já não pode ser excluida", request.getRequestURI(), true);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}
