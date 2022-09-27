package com.example.a45myapplication.domain.get_meal

import com.example.a45myapplication.common.Resourcce
import com.example.a45myapplication.data.remote.dto.DetailMeal
import com.example.a45myapplication.domain.repository.MealsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRecipeUseCase @Inject constructor(
    private val repository : MealsRepository
) {
    operator fun invoke(rId : Int) : Flow<Resourcce<DetailMeal>> = flow{
        try{
            emit(Resourcce.Loading())
            val meal = repository.getRecipe(rId)
            emit(Resourcce.Success(meal))
        }catch (e: HttpException){
            emit(Resourcce.Error(e.localizedMessage ?:"An unexpected error occured"))
        }catch (e: IOException){
            emit(Resourcce.Error("Couldn't reach server. Check your internet connection"))
        }


    }
}