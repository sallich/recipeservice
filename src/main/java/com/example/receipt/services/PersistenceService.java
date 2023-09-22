package com.example.receipt.services;

import com.example.receipt.exceptions.RecipeNotFoundException;
import com.example.receipt.repositories.RepositoryRecipe;
import com.example.receipt.entities.Recipe;
import com.example.receipt.entities.RecipeDto;
import com.example.receipt.mappers.RecipeDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PersistenceService {
    private final RepositoryRecipe repositoryRecipe;
    private final RecipeDtoMapper recipeDtoMapper;

    public RecipeDto getRecipeById(Long id){
        Optional<Recipe> recO= repositoryRecipe.findById(id);
        if(recO.isEmpty()){
            throw new RecipeNotFoundException("Recipe with id %d not found".formatted(id));
        }
        return recipeDtoMapper.toRecipeDto(recO.get());
    }
    public RecipeDto getRecipeByName(String name){
        Optional<Recipe> recO= repositoryRecipe.findByNameIgnoreCase(name);
        if(recO.isEmpty()){
            throw new RecipeNotFoundException("Recipe with name %s not found".formatted(name));
        }
        return recipeDtoMapper.toRecipeDto(recO.get());
    }
    public List<RecipeDto> getRecipeByCategory(String category){
        List<Recipe> recipes = repositoryRecipe.findAllByCategoryIgnoreCase(category);
        if (recipes.isEmpty()){
            throw new RecipeNotFoundException("Recipe with category %s not found".formatted(category));
        }
        return  recipeDtoMapper.toRecipeDto(recipes);
    }
    public void deleteRecipe(Long id){
        repositoryRecipe.deleteById(id);
    }
    public RecipeDto saveRecipe(Recipe recipe){
        return recipeDtoMapper.toRecipeDto(repositoryRecipe.save(recipe));
    }
}
