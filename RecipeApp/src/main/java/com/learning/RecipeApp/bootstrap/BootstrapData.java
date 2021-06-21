package com.learning.RecipeApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.RecipeApp.domain.Category;
import com.learning.RecipeApp.domain.UnitOfMeasure;
import com.learning.RecipeApp.repositories.CategoryRepository;
import com.learning.RecipeApp.repositories.RecipeRepository;
import com.learning.RecipeApp.repositories.UnitOfMeasureRepository;

@Component
public class BootstrapData implements CommandLineRunner{
	
	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	public BootstrapData(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String[] categories = {"American" , "Italian", "Chinese", "Mexican", "Fast Food"};
		String[] uoms = {"tsp", "tbsp", "cup", "pinch", "ounce"};
		
		//saving all categories listed in the array
		for( String category : categories ) {
			Category newCategory = new Category();
			newCategory.setCategoryName(category);
			categoryRepository.save(newCategory);
		}
		
		//saving all units of measure listed in the array
		for( String uom : uoms ) {
			UnitOfMeasure newUnitOfMeasure = new UnitOfMeasure();
			newUnitOfMeasure.setUom(uom);
			unitOfMeasureRepository.save(newUnitOfMeasure);
		}
	}

}
