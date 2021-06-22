package com.learning.RecipeApp.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.RecipeApp.domain.Category;
import com.learning.RecipeApp.domain.UnitOfMeasure;
import com.learning.RecipeApp.repositories.CategoryRepository;
import com.learning.RecipeApp.repositories.UnitOfMeasureRepository;
import com.learning.RecipeApp.services.RecipeListService;

@Controller
public class IndexController {

	private final RecipeListService recipeListService;
	
	public IndexController(RecipeListService recipeListService) {
		super();
		this.recipeListService = recipeListService;
	}

	@RequestMapping({"" , "/" , "/index" , "/index.html"})
	public String showIndex(Model model) {
		
		model.addAttribute("recipes", recipeListService.getRecipes());
	
		return "index";
	}
	
}
