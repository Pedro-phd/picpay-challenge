package com.pedrodominici.picpayjava.transaction.exceptions;
import com.pedrodominici.picpayjava.client.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientFundsException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Insufficient balance.");
        pb.setDetail("Payer don't have sufficient balance;");

        return pb;
    }
}
