/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.WebService.loja.api.exception;

import java.io.Serializable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author gabriel
 */
@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
        EmptyResultDataAccessException.class

    })
    public ResponseEntity errorNotFound(Exception ex) {
        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler({
        IllegalArgumentException.class

    })
    public ResponseEntity errorBadRequest(Exception ex) {
        return ResponseEntity.badRequest().build();

    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ExceptionError("Operação não permitida"), HttpStatus.METHOD_NOT_ALLOWED);

    }

    @ExceptionHandler({
        AccessDeniedException.class
    })
    public ResponseEntity accessDenied() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Error("Acesso negado"));
    }

    private class ExceptionError implements Serializable {

        private String error;

        public ExceptionError(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

    }

}
