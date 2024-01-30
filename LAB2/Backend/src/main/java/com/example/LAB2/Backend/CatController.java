package com.example.LAB2.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class CatController {

    private final CatService catService;

    @Autowired

    public CatController(CatService myRestService){
        this.catService = myRestService;
    }
    @GetMapping("/cat/{name}")
        public Optional<Cat> getCatByName(@PathVariable("name") String name){
        return this.catService.getCatByName(name);
    }
    @GetMapping("/cats")
    public ArrayList<Cat> getAll() {
        return this.catService.getAllCats();
    }
    @PostMapping("/cat/add")
    public void addCat(@RequestBody Cat cat){
        this.catService.addCat(cat);
    }
    @DeleteMapping("/cat/delete/{name}")
    public void deleteByName(@PathVariable("name")String name){
        this.catService.deleteCatByName(name);
    }

    @PutMapping("cat/update/{name}")
    public Optional<Cat> updateByName(@PathVariable("name")String name, @RequestBody Cat cat){
        return this.catService.updateCatByName(name, cat);
    }
}