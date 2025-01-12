package com.cocktailpick.core.userrecipe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.cocktailpick.core.common.domain.BaseTimeEntity;
import com.cocktailpick.core.ingredient.domain.Ingredient;
import com.cocktailpick.core.usercocktail.domain.UserCocktail;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserRecipeItem extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_recipe_item_sequence_gen")
    @SequenceGenerator(
        name = "user_recipe_item_sequence_gen",
        sequenceName = "user_recipe_item_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "user_cocktail_id")
    private UserCocktail userCocktail;

    @Builder
    public UserRecipeItem(Ingredient ingredient, UserCocktail userCocktail) {
        this.ingredient = ingredient;
        this.userCocktail = userCocktail;
    }
}
