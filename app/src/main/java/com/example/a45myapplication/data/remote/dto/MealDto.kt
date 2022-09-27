package com.example.a45myapplication.data.remote.dto

import com.example.a45myapplication.domain.model.Meal

data class MealDto(
    val count: Int,
    val recipes: List<Recipe>
)
 fun MealDto.toMeal(): Meal {
    return Meal(
        count = count,
        recipes = recipes
    )
}