package com.learning.RecipeApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.RecipeApp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
}
