package com.jongkeun.recipe_platform.repository;

import com.jongkeun.recipe_platform.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
