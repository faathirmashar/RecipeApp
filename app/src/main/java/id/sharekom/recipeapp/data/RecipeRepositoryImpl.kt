package id.sharekom.recipeapp.data

import androidx.lifecycle.LiveData
import id.sharekom.recipeapp.data.model.Recipe
import id.sharekom.recipeapp.data.remote.RemoteDataSource

class RecipeRepositoryImpl(private val remoteDataSource: RemoteDataSource): RecipeRepository {
    override fun getRecipes(): LiveData<List<Recipe>> = remoteDataSource.getRecipes()
    override fun setErrorHandler(errorHandlerCallback: RemoteDataSource.ErrorHandlerCallback) {
        return remoteDataSource.setOnErrorHandlerCallback(errorHandlerCallback)
    }
}