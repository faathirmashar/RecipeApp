package id.sharekom.recipeapp

import android.app.Application
import id.sharekom.recipeapp.di.AppModule
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RecipeApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger(Level.NONE)
            modules(AppModule.modules)
        }
    }
}