package com.example.a45myapplication.domain.repository

import com.example.a45myapplication.data.remote.MealApi
import com.example.a45myapplication.data.remote.dto.DetailMeal
import com.example.a45myapplication.data.remote.dto.MealDto
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val api: MealApi
): MealsRepository {
    override suspend fun getMeals(query: String): MealDto {
        return api.getMeals(query)
    }

    override suspend fun getRecipe(rId: Int): DetailMeal {
        return api.getRecipes(rId)
    }


}