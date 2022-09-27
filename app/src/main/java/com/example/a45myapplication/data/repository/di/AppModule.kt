package com.example.a45myapplication.data.repository.di

import com.example.a45myapplication.common.Constant
import com.example.a45myapplication.data.remote.MealPaprikaAPI
import com.example.a45myapplication.domain.repository.MealsRepository
import com.example.a45myapplication.domain.repository.MealsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePaprikaApi():MealPaprikaAPI{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealPaprikaAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideMealRepository(api: MealPaprikaAPI): MealsRepository{
        return MealsRepositoryImpl(api )
    }


}