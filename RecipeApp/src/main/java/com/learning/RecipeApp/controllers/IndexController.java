package com.learning.RecipeApp.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.RecipeApp.domain.Category;
import com.learning.RecipeApp.domain.UnitOfMeasure;
import com.learning.RecipeApp.repositories.CategoryRepository;
import com.learning.RecipeApp.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {
	
	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository uomRepository;
	
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository uomRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.uomRepository = uomRepository;
	}

	@RequestMapping({"" , "/" , "/index" , "/index.html"})
	public String showIndex(Model model) {
		
		Optional<Category> categoryOptional = categoryRepository.findByCategoryName("Chinese");
		Optional<UnitOfMeasure> uomOptional = uomRepository.findByUom("tbsp");
		System.out.println( categoryOptional.get() );
		System.out.println( uomOptional.get() );
		
		return "index";
	}
	
}
