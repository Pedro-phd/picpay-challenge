package com.pedrodominici.picpayjava.authorize;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizeService {

    private RestClient restClient;

    public AuthorizeService(RestClient.Builder builder){
        this.restClient = builder
                .baseUrl("https://run.mocky.io/v3/b8e921f5-4fe0-41cd-977b-02c5e901a94d").build();
    }

    public Boolean AuthorizeTransaction(){
        var response = restClient.get().retrieve().toEntity(AuthorizeResponse.class);
        return response.getBody().authorize();
    }
}
