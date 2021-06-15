package com.learning.RecipeApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.RecipeApp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
}
