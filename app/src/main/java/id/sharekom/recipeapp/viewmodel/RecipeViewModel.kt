package id.sharekom.recipeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.sharekom.recipeapp.data.RecipeRepository
import id.sharekom.recipeapp.data.model.Recipe
import id.sharekom.recipeapp.data.remote.RemoteDataSource

class RecipeViewModel(private val recipeRepository: RecipeRepository): ViewModel() {
    fun getRecipe(): LiveData<List<Recipe>> = recipeRepository.getRecipes()
    fun setErrorHandler(errorHandlerCallback: RemoteDataSource.ErrorHandlerCallback) = recipeRepository.setErrorHandler(errorHandlerCallback)
}