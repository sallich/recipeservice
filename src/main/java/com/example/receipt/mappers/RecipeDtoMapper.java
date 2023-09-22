package com.example.receipt.mappers;

import com.example.receipt.entities.Recipe;
import com.example.receipt.entities.RecipeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeDtoMapper {
    RecipeDto toRecipeDto(Recipe recipe);
    List<RecipeDto> toRecipeDto(List<Recipe> recipe);
}
