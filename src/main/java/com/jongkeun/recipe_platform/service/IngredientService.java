package com.jongkeun.recipe_platform.service;

import com.jongkeun.recipe_platform.dto.IngredientDto;
import com.jongkeun.recipe_platform.dto.IngredientResponseDto;
import com.jongkeun.recipe_platform.model.Ingredient;
import com.jongkeun.recipe_platform.repository.IngredientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientResponseDto create(IngredientDto dto){
        if (ingredientRepository.findByName(dto.getName()).isPresent()){
            throw new IllegalStateException("재료가 이미 존재합니다.");
        }

        Ingredient ingredient = new Ingredient();
        ingredient.setName(dto.getName());

        Ingredient saved = ingredientRepository.save(ingredient);

        return new IngredientResponseDto(saved.getId(), saved.getName());
    }
}
