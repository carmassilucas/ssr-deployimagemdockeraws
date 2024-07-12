package br.com.edu.ifsp.ssr.controller;

import br.com.edu.ifsp.ssr.exception.AlunoNaoEncontradoException;
import br.com.edu.ifsp.ssr.exception.ProntuarioExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ProntuarioExisteException.class)
    public ResponseEntity<String> handleProntuarioExisteException(ProntuarioExisteException e) {
        return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }

    @ExceptionHandler(AlunoNaoEncontradoException.class)
    public ResponseEntity<String> handleProntuarioExisteException(AlunoNaoEncontradoException e) {
        return ResponseEntity.unprocessableEntity().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var erros = e.getFieldErrors()
                .stream()
                .map(error -> new InvalidParam(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(erros);
    }

    private record InvalidParam(String name, String reason) {

    }
}
