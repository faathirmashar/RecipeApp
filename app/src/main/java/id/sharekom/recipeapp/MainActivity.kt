package id.sharekom.recipeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.sharekom.recipeapp.data.model.Recipe
import id.sharekom.recipeapp.data.remote.RemoteDataSource
import id.sharekom.recipeapp.databinding.ActivityMainBinding
import id.sharekom.recipeapp.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), RemoteDataSource.ErrorHandlerCallback, RecipeAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: RecipeViewModel by viewModel()
    private val adapter: RecipeAdapter = RecipeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.setErrorHandler(this)

        viewModel.getRecipe().observe(this) {
            adapter.setData(it)
            adapter.notifyDataSetChanged()
        }
        
        adapter.setOnItemClickListener(this)

        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.adapter = adapter
    }

    override fun onError(throwable: Throwable) {
        Toast.makeText(this, "${throwable.message}", Toast.LENGTH_SHORT).show()
    }

    override fun setOnClickListener(recipe: Recipe) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.DETAIL_DATA, recipe)
        startActivity(intent)
    }
}