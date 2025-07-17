package com.jongkeun.recipe_platform.controller;

import com.jongkeun.recipe_platform.dto.AddIngredientDto;
import com.jongkeun.recipe_platform.dto.RecipeDetailDto;
import com.jongkeun.recipe_platform.dto.RecipeDto;
import com.jongkeun.recipe_platform.dto.RecipeResponseDto;
import com.jongkeun.recipe_platform.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping
    public Page<RecipeResponseDto> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());

        return recipeService.list(pageable);
    }

    @GetMapping("/{id}")
    public RecipeDetailDto get(@PathVariable Long id){
        return recipeService.get(id);
    }

    @PostMapping
    public RecipeResponseDto create(@Validated @RequestBody RecipeDto dto){
        return recipeService.create(dto);
    }

    @PostMapping("/{id}/ingredients/add")
    public ResponseEntity<Void> addIngredient(
            @PathVariable Long id,
            @Validated @RequestBody AddIngredientDto dto
            ) {
        recipeService.addIngredient(id, dto);

        return ResponseEntity.ok().build();
    }
}
