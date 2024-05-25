package com.pedrodominici.picpayjava.http;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public interface HttpClientService<T> {

    CompletableFuture<HttpResponse<T>> get(URI url);
    CompletableFuture<HttpResponse<T>> post(URI url, T body);
}
