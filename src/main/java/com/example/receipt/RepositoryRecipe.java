package com.example.receipt;

import com.example.receipt.entities.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
@org.springframework.stereotype.Repository
public interface RepositoryRecipe extends CrudRepository<Recipe,Long>{
    //
    @Query
    Recipe findByName(String name);

}
