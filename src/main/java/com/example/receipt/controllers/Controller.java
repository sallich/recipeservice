package com.example.receipt.controllers;

import com.example.receipt.services.RecipeService;
import com.example.receipt.entities.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {
    private final RecipeService recipeService;
    @Autowired
    public Controller(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/recipe/{name}")
    public ResponseEntity<RecipeDto> getRecipeByName(@PathVariable String name){
        RecipeDto recipe = recipeService.getRecipeByName(name);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }
    @GetMapping("/recipe/{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id){
        RecipeDto recipe=recipeService.getRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }
    @GetMapping("/recipe/{category}")
    public ResponseEntity<List<RecipeDto>> getRecipeByCategory(@PathVariable String category){
        List<RecipeDto> recipes=recipeService.getRecipeByCategory(category);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @PostMapping("/recipe/new")
    public ResponseEntity<Long> postRecipe(@RequestBody RecipeDto recipe){
        recipeService.postRecipe(recipe);
        return ResponseEntity.ok().body(recipe.getId());
    }
    @DeleteMapping("/recipe/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PutMapping("/recipe/{id}")
    public ResponseEntity<?> putRecipe(@RequestBody RecipeDto recipe,@PathVariable Long id) {
        recipeService.putRecipe(recipe,id);
        return ResponseEntity.ok().body(HttpStatus.NO_CONTENT);
    }
}
