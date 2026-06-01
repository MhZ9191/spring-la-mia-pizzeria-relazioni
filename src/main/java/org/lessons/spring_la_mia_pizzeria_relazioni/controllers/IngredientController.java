package org.lessons.spring_la_mia_pizzeria_relazioni.controllers;

import org.lessons.spring_la_mia_pizzeria_relazioni.entities.Ingredient;
import org.lessons.spring_la_mia_pizzeria_relazioni.entities.Pizza;
import org.lessons.spring_la_mia_pizzeria_relazioni.repo.ingredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private ingredientRepo repo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("ingredients",repo.findAll());
        return "ingredients/index";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient",ingredient);
        return "ingredients/create";
    }
    
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Ingredient newIngredient, BindingResult bindingResult, Model model) {
       
        if(bindingResult.hasErrors()){
            return "ingredients/create";
        }
        
        repo.save(newIngredient);

        return "redirect:/ingredient";
    }
    
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("ingredient",repo.findById(id).get());
        model.addAttribute("edit",true);
        return "ingredients/create";
    }
    
    @PostMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Ingredient newIngredient, BindingResult bindingResult, Model model) {
        
        if(bindingResult.hasErrors()){
            return "ingredients/create";
        }

        repo.save(newIngredient);

        return "redirect:/ingredient";
    }
    
    @PostMapping("/{id}/delete")
    public String postMethodName(@PathVariable Integer id, Model model) {
        
        Ingredient ingredientToDelete = repo.findById(id).get();

        for( Pizza linkedPizza : ingredientToDelete.getPizzas() ){
            linkedPizza.getIngredients().remove(ingredientToDelete);
        }

        repo.delete(ingredientToDelete);

        return "redirect:/ingredient";
    }
    
    

}
