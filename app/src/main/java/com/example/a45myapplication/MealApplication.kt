package com.example.a45myapplication

import android.app.Application
import com.example.a45myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MealApplication : Application(){
    override fun onCreate() {
        super.onCreate()

    }
}