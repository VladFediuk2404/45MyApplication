package com.example.a45myapplication.presentation.coin_list.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.a45myapplication.common.Resource
import com.example.a45myapplication.common.collectLifecycleFlow
import com.example.a45myapplication.databinding.FragmentMealBinding
import com.example.a45myapplication.presentation.coin_list.MealListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealFragment : Fragment() {

    private var _binding: FragmentMealBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MealListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMealBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerGetMeals()

        binding.TextViewFragment.setOnClickListener {
            viewModel.getMeals("pizza")
        }

    }
    private fun observerGetMeals(){
        collectLifecycleFlow(viewModel.getMealsResult) {
            when(it) {
                is Resource.Success ->  {
                    binding.TextViewFragment.text = it.data?.recipes.toString()
                }

                is Resource.Error ->  {
                    binding.TextViewFragment.text = it.message ?: "Unknown error"
                }
                is Resource.Loading ->  {
                    binding.TextViewFragment.text = "loading"
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}