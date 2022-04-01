package id.sharekom.recipeapp.data.remote

import id.sharekom.recipeapp.data.model.Recipe
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("android-test/recipes.json")
    fun getRecipes(): Call<List<Recipe>>
}