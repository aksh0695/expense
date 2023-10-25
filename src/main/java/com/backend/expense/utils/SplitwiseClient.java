package com.backend.expense.utils;
import com.github.scribejava.core.model.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class SplitwiseClient {

    public ResponseEntity<Object> makeRequest(String url, Verb httpMethod, String accessToken, Object... data) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        //String accessToken ="UwF905Cma8mU6kwCgLaSEkrsCdZLEYezNHJUKi7y";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+accessToken);
        HashMap<String,String> map = new HashMap<>();
        map.put("name","lorem");
        HttpEntity<Object> entity = new HttpEntity<>(map,headers);
        HttpMethod a = HttpMethod.valueOf(httpMethod.name());


        ResponseEntity<Object> response = null;

            response = restTemplate.exchange(url, HttpMethod.valueOf(httpMethod.name()),entity,Object.class);

        return response;
    }
}
