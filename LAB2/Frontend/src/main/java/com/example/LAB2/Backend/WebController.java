package com.example.LAB2.Backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class WebController {
    private final CatService catService;

    public WebController(CatService myRestService){
        this.catService = myRestService;
    }
    @GetMapping(value = "/allCat")
    public String getAllCats (Model model){
        model.addAttribute("allCats",catService.getAllCats());
        return "allCats";
    }
    @GetMapping(value = "/addCat")
    public String addCat(Model model){
        model.addAttribute("cat", new Cat("",0));
        model.addAttribute("allCats", catService.getAllCats());
        return "addCat";
    }
    @PostMapping("/addCat")
    public String addCat(@ModelAttribute Cat cat){
        if (cat.getAge()<=0){
            return "addCat";
        }
        catService.addCat(cat);
        return "redirect:/allCat";
    }
    @GetMapping(value = "/updateCapybara/{name}")
    public String updateCat(Model model, @PathVariable("name") String name){
        var cat = catService.getCatByName(name);
        model.addAttribute("cat",catService.updateCatByName(name, cat));
        model.addAttribute("allCats",catService.getAllCats());
        return "updateCat";
    }

    @PostMapping(value = "/updateCat")
    public String updateCat(@ModelAttribute Cat cat){
        catService.updateCatByName(cat.getName(),cat);
        return "redirect:/allCat";
    }
    @GetMapping(value = "/deleteCat/{name}")
    public String deleteCat(@PathVariable("name") String name){
        catService.deleteCatByName(name);
        return "redirect:/allCats";
    }
}
