package com.example.a45myapplication.domain.repository

import com.example.a45myapplication.data.remote.dto.MealDto
import com.example.a45myapplication.data.remote.dto.DetailMeal

interface MealsRepository {
    suspend fun getMeals (query: String) : MealDto
    suspend fun getRecipe (rId : Int) : DetailMeal
}