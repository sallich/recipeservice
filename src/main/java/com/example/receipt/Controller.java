package com.example.receipt;

import com.example.receipt.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    private final RecipeService recipeService;
@Autowired
    public Controller(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/recipe")
    public ResponseEntity<Recipe> getRecipe(@PathVariable String name){
        Recipe recipe=recipeService.getRecipe(name);
        return recipe!=null
                ? new ResponseEntity<>(recipe, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/recipe")
    public ResponseEntity<HttpStatus> postRecipe(@RequestBody Recipe recipe){
        recipeService.postRecipe(recipe);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }

}
