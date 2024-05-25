package com.pedrodominici.picpayjava.authorize.exceptions;

import com.pedrodominici.picpayjava.client.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class NoAuthorizeException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED);

        pb.setTitle("Transfer not authorized");

        return pb;
    }

}
