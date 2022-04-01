package id.sharekom.recipeapp.di

import id.sharekom.recipeapp.BuildConfig
import id.sharekom.recipeapp.data.RecipeRepository
import id.sharekom.recipeapp.data.RecipeRepositoryImpl
import id.sharekom.recipeapp.data.remote.ApiService
import id.sharekom.recipeapp.data.remote.RemoteDataSource
import id.sharekom.recipeapp.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    private val remoteModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

        single { RemoteDataSource(get()) }
    }

    private val repositoryModule = module {
        single<RecipeRepository> { RecipeRepositoryImpl(get()) }
    }

    private val viewModel = module {
        viewModel { RecipeViewModel(get()) }
    }

    val modules = listOf(remoteModule, repositoryModule, viewModel)
}