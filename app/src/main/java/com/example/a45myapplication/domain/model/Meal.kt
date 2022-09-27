package com.example.a45myapplication.domain.model

import com.example.a45myapplication.data.remote.dto.Recipe

data class Meal(
    val count: Int,
    val recipes: List<Recipe>
)

