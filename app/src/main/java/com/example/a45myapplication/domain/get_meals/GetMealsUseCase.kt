package com.example.a45myapplication.domain.get_meals

import com.example.a45myapplication.common.Resourcce
import com.example.a45myapplication.data.remote.dto.toMeal
import com.example.a45myapplication.domain.model.Meal
import com.example.a45myapplication.domain.repository.MealsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.http.Query
import java.io.IOException
import javax.inject.Inject

class GetMealsUseCase @Inject constructor(
    private val repository : MealsRepository
) {
    operator fun invoke(query: String) : Flow<Resourcce<Meal>> = flow{
        try{
            emit(Resourcce.Loading())
            val meals = repository.getMeals((query))
            emit(Resourcce.Success(meals.toMeal()))
        }catch (e: HttpException){
            emit(Resourcce.Error(e.localizedMessage ?:"An unexpected error occured"))
        }catch (e: IOException){
            emit(Resourcce.Error("Couldn't reach server. Check your internet connection"))
        }

    }
}