package com.example.receipt;

import com.example.receipt.entities.Recipe;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    private final RecipeService recipeService;

    public Controller(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/recipe")
    public void getRecipe(@PathVariable String name){
//not void
    }
    @PostMapping("/recipe")
    public void postRecipe(@RequestBody Recipe recipe){
//not void
    }

}
