package io.apijogos.controllers;

import io.apijogos.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Fallback == página de erro padrão.
 * Dentro do pacote controller anotado com @ControllerAdvice.
 * Isso garante que todas as exceções lançadas nos controllers
 * do seu projeto sejam tratadas globalmente por essa classe.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR = "Erro: ";

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(ERROR + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>(ERROR + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

   /* @ExceptionHandler(GameNotFound.class)
    public ResponseEntity<String> handleGameNotFoundException(GameNotFound e) {
        return new ResponseEntity<>(ERROR + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GameNotFound.class)
    public ResponseEntity<String> handleGameListNotFoundException(GameListNotFound e) {
        return new ResponseEntity<>(ERROR + e.getMessage(), HttpStatus.NOT_FOUND);
    }*/

}