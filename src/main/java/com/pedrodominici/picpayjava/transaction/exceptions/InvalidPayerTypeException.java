package com.pedrodominici.picpayjava.transaction.exceptions;

import com.pedrodominici.picpayjava.DefaultResponse;
import com.pedrodominici.picpayjava.client.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InvalidPayerTypeException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Payer type is invalid");
        pb.setDetail("Only 'LOJISTA' payer is valid");

        return pb;
    }
}
