package com.example.receipt.mappers;

import com.example.receipt.entities.Recipe;
import com.example.receipt.entities.RecipeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    Recipe toRecipe(RecipeDto recipe);
}
