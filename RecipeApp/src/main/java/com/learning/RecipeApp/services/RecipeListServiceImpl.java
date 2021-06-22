package com.learning.RecipeApp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.learning.RecipeApp.domain.Recipe;
import com.learning.RecipeApp.repositories.RecipeRepository;

@Service
public class RecipeListServiceImpl implements RecipeListService {
	
	private final RecipeRepository recipeRepository;

	public RecipeListServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		// TODO Auto-generated method stub
		Set<Recipe> recipes = new HashSet<>();
		for( Recipe rec : recipeRepository.findAll() ) {
			recipes.add(rec);
		}
		return recipes;
	}

}
