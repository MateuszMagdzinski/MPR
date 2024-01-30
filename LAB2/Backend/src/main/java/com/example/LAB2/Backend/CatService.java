package com.example.LAB2.Backend;

import com.example.LAB2.Backend.exception.CatExist;
import com.example.LAB2.Backend.exception.CatNotExist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public Optional<Cat> addCat(Cat cat) {
        if (repository.findByName(cat.getName()).isEmpty())
            return Optional.of(this.repository.save(cat));
        else
            throw new CatExist();
    }
    public void deleteCatByName(String name) {
        var capybara = this.repository.findByName(name);
        if (capybara.isPresent())
            this.repository.delete(capybara.get());
        else
            throw new CatExist();
    }
    public Optional<Cat> updateCatByName(String name, Cat cat1) {
        var cat = this.repository.findByName(name);
        if (cat.isPresent()) {
            if (cat.get().getAge() <= cat1.getAge())
                cat.get().setAge(cat1.getAge());
            return Optional.of(this.repository.save(cat.get()));
        } else {
            throw new CatNotExist();
        }
    }
    public List<Cat> findCatsThatNameIsContainsNameFromLink(String name) {
        var catListWithAllCats = ((ArrayList<Cat>) this.repository.findAll());
        return catListWithAllCats.stream()
                .filter(cat -> cat.getName().contains(name))
                .toList();
    }
}
