package com.example.receipt.services;

import com.example.receipt.entities.Recipe;
import com.example.receipt.entities.RecipeDto;
import com.example.receipt.mappers.RecipeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeMapper recipeMapper;

    private final PersistenceService persistenceService;
    //возвращает текущий рецепт в виде объекта JSON
    public RecipeDto getRecipeByName(String name){
        return persistenceService.getRecipeByName(name);
    }
    public RecipeDto getRecipeById(Long id){
        return persistenceService.getRecipeById(id);
    }
    public List<RecipeDto> getRecipeByCategory(String category){
        return persistenceService.getRecipeByCategory(category);
    }
    //получает рецепт в виде объекта JSON и переопределяет текущий рецепт.
    public RecipeDto postRecipe(RecipeDto recipe){
        return persistenceService.saveRecipe(recipeMapper.toRecipe(recipe));
    }
    public void deleteRecipe(Long id){
        persistenceService.deleteRecipe(id);
    }
    public RecipeDto putRecipe(RecipeDto recipeDto,Long id){
        if (persistenceService.getRecipeById(id) == null) {
            return null;
        }
        recipeDto.setId(id);
        Recipe recipe = recipeMapper.toRecipe(recipeDto);
        return persistenceService.saveRecipe(recipe);
    }

}