package com.learning.RecipeApp.services;

import java.util.Set;

import com.learning.RecipeApp.domain.Recipe;

public interface RecipeListService {
	Set<Recipe> getRecipes();
}
