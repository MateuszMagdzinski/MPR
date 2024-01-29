package com.example.LAB2.Backend;

import com.example.LAB2.Backend.Cat;
import com.example.LAB2.Backend.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class WebController {
    private final CatService catService;

    public WebController(CatService myRestService){
        this.catService = myRestService;
    }
    @GetMapping("/allCats")
    public String getViewAll (Model model){
        model.addAttribute("allCats",service.getAllCapybaras());
        return "allCats";
    }
    @PostMapping("/cat/add")
    public String addCapybara(@ModelAttribute Cat cat){
        if (cat.getAge()<=0){
            return "addCats";
        }
        service.addCapybara(capybara);
        return "redirect:/allCats";
    }
    @DeleteMapping("/cat/delete/{name}")
    public String deleteCat(@PathVariable("name") String name){
        service.deleteCatByName(name);
        return "redirect:/allCat";
    }
    @PutMapping("cat/update/{name}")
    public String updateCat(@ModelAttribute Cat cat){
        service.updateCatByName(cat.getName(),cat);
        return "redirect:/allCats";
    }

}
