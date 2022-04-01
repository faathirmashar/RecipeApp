package id.sharekom.recipeapp.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.sharekom.recipeapp.data.model.Recipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService) {
    private lateinit var errorHandlerCallback: ErrorHandlerCallback

    fun setOnErrorHandlerCallback(errorHandlerCallback: ErrorHandlerCallback) {
        this.errorHandlerCallback = errorHandlerCallback
    }

    fun getRecipes(): LiveData<List<Recipe>> {
        val listData = MutableLiveData<List<Recipe>>()

        apiService.getRecipes().enqueue(object : Callback<List<Recipe>> {
            override fun onResponse(call: Call<List<Recipe>>, response: Response<List<Recipe>>) {
                val body = response.body()
                if (body != null) {
                    listData.postValue(body as ArrayList<Recipe>)
                }
            }

            override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {
                errorHandlerCallback.onError(throwable = t)
            }
        })

        return listData
    }

    interface ErrorHandlerCallback {
        fun onError(throwable: Throwable)
    }
}