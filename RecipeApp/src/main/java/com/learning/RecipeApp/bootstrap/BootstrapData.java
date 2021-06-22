package com.learning.RecipeApp.bootstrap;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.RecipeApp.domain.Category;
import com.learning.RecipeApp.domain.Ingredient;
import com.learning.RecipeApp.domain.Notes;
import com.learning.RecipeApp.domain.Recipe;
import com.learning.RecipeApp.domain.UnitOfMeasure;
import com.learning.RecipeApp.repositories.CategoryRepository;
import com.learning.RecipeApp.repositories.RecipeRepository;
import com.learning.RecipeApp.repositories.UnitOfMeasureRepository;

@Component
public class BootstrapData implements CommandLineRunner{
	
	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	public String error = "";

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
		String[] categories = {"American" , "Italian", "Chinese", "Mexican", "Fast Food", "Veg"
				, "Non-veg" };
		String[] uoms = {"tsp", "tbsp", "cup", "pinch", "ounce", "pint", "clove"};
		
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
		
		/*
		 * Adding the PERFECT GUACAMOLE recipe to the Recipe Repository
		 */
		Recipe perfectGuacamole = new Recipe();
		perfectGuacamole.setDescription("Perfect Guacamole");
		Notes guacaNotes = new Notes();
		guacaNotes.setRecipeNotes("Be careful handling chilis! If using, it's best"
				+ " to wear food-safe gloves. If no gloves are available, wash your hands"
				+ " thoroughly after handling, and do not touch your eyes or the area near "
				+ "your eyes for several hours afterwards.");
		guacaNotes.setRecipe(perfectGuacamole);
		perfectGuacamole.setNotes(guacaNotes);
		
		HashSet<Category> guacamoleCategories = new HashSet<>();
		guacamoleCategories.add( categoryRepository.findByCategoryName("Mexican").get() );
		guacamoleCategories.add( categoryRepository.findByCategoryName("Veg").get() ); 
		perfectGuacamole.setCategories(guacamoleCategories);
		perfectGuacamole.setCookTime(0);
		perfectGuacamole.setPrepTime(10);
		perfectGuacamole.setServings(4);
		
		Set<Ingredient> guacamoleIngredients = new HashSet<>();
		String[] ingredients = { "ripe avocadoes" , "salt" , "lemon juice" ,
					"minced red onion/sliced green onion", "serrano/jalepeno stems n seeds removed n minced" ,
					"cilantro finely chopped", "freshly ground black pepper", "ripe tomato(es)" ,
					"red radish/jicama slices for garnish", "Tortilla chips to serve"};
		String[] amounts = {"2", "0.25", "1", "3", "2", "2", "1", "0.5", null, null};
		String[] uomValues = {null, "tsp", "tbsp", "tbsp",null, "tbsp", "pinch", null, null, null};
		for( int i = 0; i < ingredients.length; i++ ) {
			Ingredient newIngredient = new Ingredient();
			BigDecimal newAmount = amounts[i] == null ? null : new BigDecimal(amounts[i]);
			newIngredient.setAmount( newAmount );
			newIngredient.setDescription(ingredients[i]);
			UnitOfMeasure newUOM = uomValues[i] == null ? null : unitOfMeasureRepository.findByUom(uomValues[i]).get();
			newIngredient.setUom( newUOM   );
			newIngredient.setRecipe(perfectGuacamole);
			perfectGuacamole.getIngredients().add(newIngredient);
		}
		recipeRepository.save(perfectGuacamole);
		
		/*
		 * Adding the SPICY GRILLED CHICKEN recipe to the Recipe Repository
		 */
		Recipe grilledChicken = new Recipe();
		grilledChicken.setDescription("Spicy Grilled Chicken Tacos");
		Notes chickenNotes = new Notes();
		chickenNotes.setRecipeNotes("Look for ancho chile powder with the"
				+ " Mexican ingredients at your grocery store, on buy it online. "
				+ "(If you can't find ancho chili powder, you replace the ancho chili,"
				+ " the oregano, and the cumin with 2 1/2 tablespoons regular chili powder,"
				+ " though the flavor won't be quite the same.)");
		chickenNotes.setRecipe(grilledChicken);
		grilledChicken.setNotes(chickenNotes);
		
		HashSet<Category> grilledChickenCategories = new HashSet<>();
		grilledChickenCategories.add( categoryRepository.findByCategoryName("Mexican").get() );
		grilledChickenCategories.add( categoryRepository.findByCategoryName("Fast Food").get() );
		grilledChickenCategories.add( categoryRepository.findByCategoryName("Non-veg").get() );
		grilledChicken.setCategories(grilledChickenCategories);
		grilledChicken.setCookTime(15);
		grilledChicken.setPrepTime(20);
		grilledChicken.setServings(5);
		
		Set<Ingredient> grilledChickenIngredients = new HashSet<>();
		String[] ingredients2 = {"ancho chilli powder", "dried oregano", "dried cumin", "sugar"
				, "salt", "garlic, finely chopped", "finely grated orange zest", "fresh-squeezed orange juice"
				, "olive oil", "skinless, boneless chicken thighs", "small corn tortillas"
				, "packed baby arugula", "medium ripe avocados, sliced", "radishes, thinly sliced"
				, "cherry tomatoes, halved", "red onion, thinly sliced"};
		String[] amounts2 = {"2", "1", "1", "1", "0.5", "1", "1", "3", "2", "5", "8", "3", "2", "4"
				, "0.5", "0.25"};
		String[] uomValues2 = {"tbsp", "tsp", "tsp", "tsp", "tsp", "clove", "tbsp", "tbsp", "tbsp", null, null
				, "cup", null, null, "pint", null};
		for( int i = 0; i < ingredients2.length; i++ ) {
			Ingredient newIngredient = new Ingredient();
			BigDecimal newAmount = amounts2[i] == null ? null : new BigDecimal(amounts2[i]);
			newIngredient.setAmount( newAmount );
			newIngredient.setDescription(ingredients2[i]);
			error = uomValues2[i];
			UnitOfMeasure newUOM = uomValues2[i] == null ? null : unitOfMeasureRepository.findByUom(uomValues2[i]).get();
			newIngredient.setUom(newUOM);
			newIngredient.setRecipe(grilledChicken);
			grilledChicken.getIngredients().add(newIngredient);
		}
		recipeRepository.save(grilledChicken);
	}

}
