package com.example.LAB2.Backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.ArrayList;

@Service
public class CatService {
    public static final String BASE_URL = "http://localhost:8080";
    @Autowired
    RestClient restClient;

    public CatService(RestClient restCLient){this.restClient = restCLient;}
    public Cat getCatByName(String name){
        return restClient
                .get()
                .uri(BASE_URL + "/cat/" + name)
                .retrieve()
                .body(Cat.class);
    }
    public ArrayList<Cat> getAllCats() {
        return restClient
                .get()
                .uri(BASE_URL + "/cats")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    public void addCat(Cat cat) {
        ResponseEntity<Void> response = restClient
                .post()
                .uri(BASE_URL + "/cat/add")
                .contentType(MediaType.APPLICATION_JSON)
                .body(cat)
                .retrieve()
                .toBodilessEntity();
    }

    public void deleteCatByName(String name) {
        ResponseEntity<Void> response = restClient
                .delete()
                .uri(BASE_URL + "/cat/delete/" + name)
                .retrieve()
                .toBodilessEntity();
    }

    public Cat updateCatByName(String name, Cat cat) {
        return restClient
                .put()
                .uri(BASE_URL + "/cat/update/" + name)
                .body(cat)
                .retrieve()
                .body(Cat.class);
    }

}
