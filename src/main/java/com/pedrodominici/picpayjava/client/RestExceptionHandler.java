package com.pedrodominici.picpayjava.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PicPayException.class)
    public ProblemDetail handle(PicPayException ex){
        return  ex.toProblemDetail();
    }

    // TRATAMENTO PARA EXCEPTIONS COM ERROS DE CAMPOS INVALIDOS
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        var fieldErrors = ex.getFieldErrors()
                .stream()
                .map(f -> new InvalidFields(f.getField(), f.getDefaultMessage()))
                .toList();

        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Your request parameters didn't validate.");
        pb.setProperty("fields", fieldErrors);

        return pb;
    }


}
