package com.pedrodominici.picpayjava;

public record DefaultResponse(String message) {
    public static DefaultResponse Message(String msg){
        return new DefaultResponse(msg);
    }
}
