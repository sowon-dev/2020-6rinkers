package com.cocktailpick.core.ingredient.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cocktailpick.core.common.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Ingredient extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_sequence")
    @SequenceGenerator(
        name = "ingredient_sequence_gen",
        sequenceName = "ingredient_sequence"
    )
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String color;

    @NotNull
    private Double abv;

    @Builder
    public Ingredient(Long id, @NotBlank String title, @NotBlank String color, @NotNull Double abv) {
        this.id = id;
        this.title = title;
        this.color = color;
        this.abv = abv;
    }

    public void update(Ingredient requestIngredient) {
        this.title = requestIngredient.title;
        this.color = requestIngredient.color;
        this.abv = requestIngredient.abv;
    }
}
