package com.example.receipt.entities;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class RecipeDto {

    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;

    private List<String> ingredients;

    private List<String> directions;
    @NotEmpty
    private String category;
}
