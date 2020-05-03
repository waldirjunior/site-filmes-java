package com.terrivelbox.sitefilmes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Main {

    @GetMapping("/")
    public String index(){
        return "Hello World 2";
    }

    @GetMapping("/filmes/{pathNomeFilme}")
    public ResponseEntity filmes(@PathVariable(required = false) String pathNomeFilme, @RequestParam(required = false) String nomeFilme){
        RestTemplate restTemplate = new RestTemplate();

        if(pathNomeFilme == null){
            pathNomeFilme = nomeFilme;
        }
        String uri
                = "https://api.themoviedb.org/3/search/movie?api_key=c158b2f342a0f004be2bf12d2a039b42&language=pt-BR&query=%s&page=1&include_adult=fals";

        uri = String.format(uri, pathNomeFilme);
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        return response;
    }
}
