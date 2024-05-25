package com.pedrodominici.picpayjava.costumers.exceptions;

import com.pedrodominici.picpayjava.DefaultResponse;
import com.pedrodominici.picpayjava.client.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CostumerNotFoundException extends PicPayException {

    String message;

    public CostumerNotFoundException(String msg) {
        this.message = msg;
    }

    @Override
    public ProblemDetail toProblemDetail() {

        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Costumer no found");
        pb.setDetail("Costumer with id" + message + "not found");

        return pb;
    }
}
