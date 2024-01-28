package com.example.LAB2;

import com.example.LAB2.exception.CatExist;
import com.example.LAB2.exception.CatNotExist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CatService {
    CatsRepository repository;
    public CatService(CatsRepository repository){
        this.repository = repository;
        this.repository.save(new Cat("janek",8));
        this.repository.save(new Cat("marek",2));
        this.repository.save(new Cat("karol",5));
        this.repository.save(new Cat("dawid",4));

    }

    public Optional<Cat> getCatByName (String name){
        if (this.repository.findByName(name).isPresent())
            return this.repository.findByName(name);
            else throw new CatNotExist();}
    public ArrayList<Cat> getAllCats() {
        if (!((ArrayList<Cat>) this.repository.findAll()).isEmpty())
            return (ArrayList<Cat>) this.repository.findAll();
        else throw new CatNotExist();
    }
    public Optional<Cat> addCat(Cat cat){
        if (repository.findByName(cat.getName()).isEmpty())
            return Optional.of(this.repository.save(cat));
    else
    throw new CatExist();
    }
    public void deleteCatByName(String name){
        Cat cat = this.repository.findByName(name);
        this.repository.delete(cat);
    }
    public Cat updateCatByName(String name, Cat cat1){
        Cat cat = this.repository.findByName(name);
        if (!this.repository.findByName(cat.getName()).getName().isEmpty()){
    cat.setName(cat1.getName());
    cat.setAge(cat1.getAge());
    this.repository.save(cat);
        }
        return cat;
    }
}
