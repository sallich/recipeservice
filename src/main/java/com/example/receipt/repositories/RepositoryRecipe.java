package com.example.receipt.repositories;

import com.example.receipt.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryRecipe extends JpaRepository<Recipe,Long> {
    Optional<Recipe> findByNameIgnoreCase(String name);
    List<Recipe> findAllByCategoryIgnoreCase(String category);

}
