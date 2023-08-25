package com.example.receipt;

import com.example.receipt.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final RepositoryRecipe repository;

    @Autowired
    public RecipeService(RepositoryRecipe repository) {
        this.repository = repository;
    }
    //возвращает текущий рецепт в виде объекта JSON
    public Recipe getRecipe(String name){
        return repository.findByName(name);

    }
    //получает рецепт в виде объекта JSON и переопределяет текущий рецепт.
    public Recipe postRecipe(Recipe recipe){
        return repository.save(recipe);


    }
}