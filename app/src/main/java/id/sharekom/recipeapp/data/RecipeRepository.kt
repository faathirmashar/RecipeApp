package id.sharekom.recipeapp.data

import androidx.lifecycle.LiveData
import id.sharekom.recipeapp.data.model.Recipe
import id.sharekom.recipeapp.data.remote.RemoteDataSource

interface RecipeRepository {
    fun getRecipes(): LiveData<List<Recipe>>
    fun setErrorHandler(errorHandlerCallback: RemoteDataSource.ErrorHandlerCallback)
}