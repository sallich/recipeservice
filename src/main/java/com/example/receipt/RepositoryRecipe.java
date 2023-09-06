package com.example.receipt;

import com.example.receipt.entities.Recipe;
import org.springframework.data.repository.CrudRepository;
@org.springframework.stereotype.Repository
public interface RepositoryRecipe extends CrudRepository<Recipe,Long>{
    Recipe findByName(String name);

}
