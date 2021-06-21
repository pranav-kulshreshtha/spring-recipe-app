package com.learning.RecipeApp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.learning.RecipeApp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
	Optional<UnitOfMeasure> findByUom(String uom);
}
