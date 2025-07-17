package com.jongkeun.recipe_platform.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 생성자 어노테이션 빼거나 둘 다 넣거나. 테스트 시 필요.
public class RecipeDto {
    @NotBlank
    private String title;

    private String description;
}
