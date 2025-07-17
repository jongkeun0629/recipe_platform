package com.jongkeun.recipe_platform.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
// Serializable: id 형태를 스트림 형태로 전환
public class RecipeIngredientId implements Serializable {
    private Long recipeId;
    private Long ingredientId;
}
