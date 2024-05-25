package com.pedrodominici.picpayjava.costumers.exceptions;

import com.pedrodominici.picpayjava.client.InvalidFields;
import com.pedrodominici.picpayjava.client.PicPayException;
import com.pedrodominici.picpayjava.client.RestExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.BindingResult;

public class CostumerInvalidFieldsException extends PicPayException {

    BindingResult errors;

    public CostumerInvalidFieldsException(BindingResult errors) {
        this.errors = errors;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var fieldErrors = errors.getFieldErrors()
                .stream()
                .map(f -> new InvalidFields(f.getField(), f.getDefaultMessage()))
                .toList();

        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Your request parameters didn't validate.");
        pb.setProperty("fields", fieldErrors);

        return pb;
    }
}
