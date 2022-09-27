package com.example.a45myapplication.data.remote

import com.example.a45myapplication.data.remote.dto.DetailMeal
import com.example.a45myapplication.data.remote.dto.MealDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("/search?")
    suspend fun getMeals(@Query("q") q : String?) : MealDto
    @GET("/get?")
    suspend fun getRecipes(@Query("rId") rId : Int ) : DetailMeal
}