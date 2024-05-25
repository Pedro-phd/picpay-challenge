package com.pedrodominici.picpayjava.http;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientServiceImpl implements HttpClientService<String> {

    private final HttpClient httpClient;

    public HttpClientServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public CompletableFuture<HttpResponse<String>> get(URI url) {
        HttpRequest request = HttpRequest.newBuilder(url).GET().build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public CompletableFuture<HttpResponse<String>> post(URI url, String body) {
        HttpRequest request = HttpRequest.newBuilder(url)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }
}

